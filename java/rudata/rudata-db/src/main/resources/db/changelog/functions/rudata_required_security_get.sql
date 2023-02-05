create or replace function rudata.required_security_get(in in_isin varchar(255))
    returns table(id int, "timestamp" timestamp, isin varchar(255), active boolean)
as $$
select i.id, i.timestamp, i.isin, i.active
from
    rudata.required_security i
where
        i.isin = in_isin;
$$ language sql;