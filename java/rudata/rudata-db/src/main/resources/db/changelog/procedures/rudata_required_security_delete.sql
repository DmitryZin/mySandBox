create or replace procedure rudata.required_security_delete(in_isin varchar(255))
    language plpgsql
as
$$
begin
    delete from rudata.required_security
    where isin = in_isin;
end;
$$;