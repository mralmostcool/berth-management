CREATE TYPE berth_status AS ENUM ('available', 'occupied', 'expired');

CREATE TABLE IF NOT EXISTS berth (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    berth_code VARCHAR(64) NOT NULL UNIQUE,
    vessel_id UUID REFERENCES vessel(id) ON DELETE SET NULL,
    status berth_status NOT NULL DEFAULT 'available',
    start_date TIMESTAMPTZ NOT NULL,
    expiry_date TIMESTAMPTZ NOT NULL,
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

CREATE TRIGGER trg_berth_updated_at
    BEFORE UPDATE ON berth
    FOR EACH ROW
    EXECUTE FUNCTION set_updated_at();