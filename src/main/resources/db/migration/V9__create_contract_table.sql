CREATE TYPE contract_status AS ENUM (
    'pending',
    'approved',
    'rejected'
);

CREATE TABLE IF NOT EXISTS contract (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    shipping_company_id UUID NOT NULL REFERENCES shipping_company(id) ON DELETE CASCADE,
    student_id UUID REFERENCES student(id) ON DELETE SET NULL,
    rank VARCHAR(255) NOT NULL,
    start_date TIMESTAMPTZ NOT NULL,
    status contract_status NOT NULL DEFAULT 'approved',
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE OR REPLACE FUNCTION set_udpated_at()
    RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_contract_updated_at
    BEFORE UPDATE ON enrollment
    FOR EACH ROW
    EXECUTE FUNCTION set_updated_at();