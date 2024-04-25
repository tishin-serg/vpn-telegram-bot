DROP TABLE IF EXISTS "user";

-- Create user table
CREATE TABLE "user" (
                        user_id SERIAL PRIMARY KEY,
                        chat_id BIGINT NOT NULL,
                        is_active BOOLEAN NOT NULL DEFAULT FALSE,
                        has_used_trial BOOLEAN NOT NULL DEFAULT FALSE
);