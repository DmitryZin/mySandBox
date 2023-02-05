create table if not exists rudata.method(
    id              int             not null generated always as identity,
    "timestamp"     timestamp       not null default current_timestamp,
    url             varchar(255)    not null,
    "name"          varchar(255)    not null,
    save_procname   varchar(255)    not null,
    smart_filter    jsonb           null,
    last_load       timestamp       null,
    next_load       timestamp       not null default current_timestamp,
    load_interval   int             not null,
    active          boolean         not null default true,
    constraint rudata_method_pk primary key (id)
);

comment on table rudata.method is 'Список методов на загрузку данных из рудаты';
comment on column rudata.method.id is 'Идентификатор таблицы';
comment on column rudata.method.timestamp is 'Время добавления записи';
comment on column rudata.method.url is 'Адрес получения данных';
comment on column rudata.method.name is 'Наименование контроллера';
comment on column rudata.method.save_procname is 'Процедура для сохранения данных';
comment on column rudata.method.smart_filter is 'Фильтр для формирования body запроса';
comment on column rudata.method.last_load is 'Время последней загрузки данных';
comment on column rudata.method.next_load is 'Следующий момент запуска';
comment on column rudata.method.load_interval is 'Интервал загрузки, в секундах1';
comment on column rudata.method.active is 'Загружать ли текущий метод';
