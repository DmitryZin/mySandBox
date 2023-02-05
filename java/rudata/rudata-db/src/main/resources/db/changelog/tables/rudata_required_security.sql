create table if not exists rudata.required_security(
    id              int             not null generated always as identity,
    "timestamp"     timestamp       not null default current_timestamp,
    isin            varchar(255)    not null,
    active          boolean         not null default true,
    constraint rudata_required_security_pk primary key (id),
    constraint rudata_required_security_uq unique (isin)
);

comment on table rudata.required_security is 'Список бумаг на загрузку данных из рудаты';
comment on column rudata.required_security.id is 'Идентификатор таблицы';
comment on column rudata.required_security.timestamp is 'Время добавления записи';
comment on column rudata.required_security.isin is 'ISIN бумаги';
comment on column rudata.required_security.active is 'Загружать ли текущий метод';
