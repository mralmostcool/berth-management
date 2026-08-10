CREATE TYPE allocation_status AS ENUM (
    'scheduled',
    'active',
    'completed',
    'cancelled'
);

CREATE TABLE IF NOT EXISTS allocation (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    contract_id UUID NOT NULL REFERENCES contract(id) ON DELETE CASCADE,
    student_id UUID NOT NULL REFERENCES student(id) ON DELETE CASCADE,
    berth_id UUID NOT NULL REFERENCES berth(id) ON DELETE CASCADE,
    status allocation_status NOT NULL DEFAULT 'scheduled',
    plannded_start_date TIMESTAMPTZ,
    planned_end_date TIMESTAMPTZ,
    sign_on_date TIMESTAMPTZ,
    sign_off_date TIMESTAMPTZ,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE OR REPLACE FUNCTION set_updated_at()
    RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_allocation_updated_at
    BEFORE UPDATE ON allocation
    FOR EACH ROW
    EXECUTE FUNCTION set_updated_at();