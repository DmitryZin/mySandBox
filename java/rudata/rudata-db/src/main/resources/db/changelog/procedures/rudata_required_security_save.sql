create or replace procedure rudata.required_security_save(data text)
    language plpgsql
as
$$
begin
    drop table if exists tmp_required_security;

    create temp table tmp_required_security(
                                  isin            varchar(255)    not null,
                                  active          boolean         not null default true
    );

    insert into tmp_required_security(isin, active)
    select distinct isin, active
    from
        jsonb_to_recordset(data::jsonb) as t(
                                             isin    varchar(255),
                                             active  boolean
            );

    merge into rudata.required_security ca
        using tmp_required_security t
        on t.isin = ca.isin
    when matched then
    update set active = t.active
    when not matched then
    insert (isin, active)
    values (t.isin, t.active);
end;
$$;