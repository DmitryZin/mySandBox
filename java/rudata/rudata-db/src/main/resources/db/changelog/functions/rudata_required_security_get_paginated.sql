create or replace function rudata.required_security_get_paginated(in in_page_num int, in_page_count int)
    returns table(id int, "timestamp" timestamp, isin varchar(255), active boolean)
as $$
select i.id, i.timestamp, i.isin, i.active
from
    rudata.required_security i
where
    i.active = true
limit in_page_count
offset ((in_page_num - 1) * in_page_count);
$$ language sql;