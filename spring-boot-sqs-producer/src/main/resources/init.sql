create table upload_file_meta (
    id bigserial not null,
    created_time timestamp,
    updated_time timestamp,
    upload_url varchar(1000),
    file_size bigint,
    file_unique_id varchar(255),
    primary key (id)
);

alter table if exists upload_file_meta add constraint idx_upload_file_meta_unique_id unique (file_unique_id);