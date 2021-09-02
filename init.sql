create table if not exists public.cards
(
    favor          boolean,
    count_seen     integer,
    time_last_seen timestamp,
    name           text,
    content        text,
    hide           boolean,
    id             serial not null
        constraint cards_pkey
            primary key
);