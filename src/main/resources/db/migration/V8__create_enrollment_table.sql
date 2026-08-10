CREATE TYPE enrollment_status AS ENUM ('enrolled', 'ongoing', 'completed', 'cancelled');

CREATE TABLE IF NOT EXISTS enrollment (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    student_id UUID NOT NULL REFERENCES student(id) ON DELETE CASCADE,
    pre_sea_course_id UUID NOT NULL REFERENCES pre_sea_course(id) ON DELETE CASCADE,
    status enrollment_status NOT NULL DEFAULT 'enrolled',
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

CREATE TRIGGER trg_enrollment_updated_at
    BEFORE UPDATE ON enrollment
    FOR EACH ROW
    EXECUTE FUNCTION set_updated_at();