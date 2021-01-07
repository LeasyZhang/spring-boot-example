DROP TABLE IF EXISTS "news_0";
CREATE TABLE "news_0" (
    "id" serial,
    "title" text,
    "author" text,
    "content" jsonb,
    PRIMARY KEY ("id")
);
DROP TABLE IF EXISTS "news_1";
CREATE TABLE "news_1" (
    "id" serial,
    "title" text,
    "author" text,
    "content" jsonb,
    PRIMARY KEY ("id")
);
DROP TABLE IF EXISTS "news_2";
CREATE TABLE "news_2" (
    "id" serial,
    "title" text,
    "author" text,
    "content" jsonb,
    PRIMARY KEY ("id")
);