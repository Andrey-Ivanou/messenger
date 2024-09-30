      CREATE SCHEMA app
        AUTHORIZATION postgres;


      CREATE TABLE app.entity_user
      (
          id character varying NOT NULL,
          password character varying NOT NULL,
          full_name character varying NOT NULL,
          date_of_birht date NOT NULL,
          create_at timestamp NOT NULL,
          role character varying NOT NULL,
          PRIMARY KEY (id)
      );

      ALTER TABLE IF EXISTS app.entity_user
          OWNER to postgres;