
CREATE TABLE article (
   id UUID PRIMARY KEY,
   name varchar not null,
   code varchar not null,
   created timestamp not null
);

CREATE TABLE price (
   id UUID PRIMARY KEY,
   article_id UUID not null,
   created timestamp not null,
   price decimal not null,
   CONSTRAINT article_price_id_fkey FOREIGN KEY (article_id)
   REFERENCES article (id) MATCH SIMPLE
);