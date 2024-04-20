CREATE TABLE IF NOT EXISTS public.demo
(
    id bigint NOT NULL,
    gmt_create bigint NOT NULL,
    gmt_modified bigint NOT NULL,
    code character varying(128) COLLATE pg_catalog."default" NOT NULL,
    name character varying(128) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT demo_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.demo
    OWNER to postgres;

COMMENT ON COLUMN public.demo.id
    IS '主键';

COMMENT ON COLUMN public.demo.gmt_create
    IS '创建时间';

COMMENT ON COLUMN public.demo.gmt_modified
    IS '修改时间';

COMMENT ON COLUMN public.demo.code
    IS '编码';

COMMENT ON COLUMN public.demo.name
    IS '名称';