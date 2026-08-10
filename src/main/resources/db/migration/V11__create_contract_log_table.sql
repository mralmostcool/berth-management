CREATE TYPE contract_action AS ENUM (
    'sign_on',
    'sign_off'
);

CREATE TABLE IF NOT EXISTS contract_log (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    contract_id UUID NOT NULL REFERENCES contract(id) ON DELETE CASCADE,
    allocation_id UUID NOT NULL REFERENCES allocation(id) ON DELETE CASCADE,
    action contract_action,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
)