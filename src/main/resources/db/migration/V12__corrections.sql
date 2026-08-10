-- V12__corrections.sql
-- Corrections migration: fixes column typo, adds missing FK indexes,
-- and adds a unique constraint on student.indos.
-- Written additively (no edits to prior migrations) per project convention.

-- ============================================================
-- 1. Fix column typo: plannded_start_date -> planned_start_date
-- ============================================================
ALTER TABLE public.allocation
    RENAME COLUMN plannded_start_date TO planned_start_date;

-- ============================================================
-- 2. Add missing indexes on foreign key columns
--    (Postgres does not auto-index FK columns; these are all
--    frequently joined/filtered on)
-- ============================================================
CREATE INDEX IF NOT EXISTS idx_vessel_flag_id
    ON public.vessel (flag_id);

CREATE INDEX IF NOT EXISTS idx_vessel_shipping_company_id
    ON public.vessel (shipping_company_id);

CREATE INDEX IF NOT EXISTS idx_berth_vessel_id
    ON public.berth (vessel_id);

CREATE INDEX IF NOT EXISTS idx_enrollment_student_id
    ON public.enrollment (student_id);

CREATE INDEX IF NOT EXISTS idx_enrollment_pre_sea_course_id
    ON public.enrollment (pre_sea_course_id);

CREATE INDEX IF NOT EXISTS idx_contract_shipping_company_id
    ON public.contract (shipping_company_id);

CREATE INDEX IF NOT EXISTS idx_contract_student_id
    ON public.contract (student_id);

CREATE INDEX IF NOT EXISTS idx_allocation_contract_id
    ON public.allocation (contract_id);

CREATE INDEX IF NOT EXISTS idx_allocation_student_id
    ON public.allocation (student_id);

CREATE INDEX IF NOT EXISTS idx_allocation_berth_id
    ON public.allocation (berth_id);

CREATE INDEX IF NOT EXISTS idx_contract_log_contract_id
    ON public.contract_log (contract_id);

CREATE INDEX IF NOT EXISTS idx_contract_log_allocation_id
    ON public.contract_log (allocation_id);

-- ============================================================
-- 3. Add unique constraint on student.indos
--    NOTE: run this block first if you suspect duplicate/null
--    indos values already exist in production - it will FAIL
--    the migration if duplicates are present. See comment below.
-- ============================================================

-- Sanity check (manual): before running in prod, you may want to
-- verify there are no duplicate indos values first:
--   SELECT indos, COUNT(*) FROM public.student
--   WHERE indos IS NOT NULL GROUP BY indos HAVING COUNT(*) > 1;

ALTER TABLE public.student
    ADD CONSTRAINT student_indos_unique UNIQUE (indos);

-- ============================================================
-- 4. TIMESTAMPTZ consistency check
--    All application tables (flags, shipping_company, vessel,
--    berth, student, pre_sea_course, enrollment, contract,
--    allocation, contract_log) already use
--    `timestamp with time zone` for their date/time columns.
--    The only column found using plain `timestamp` is
--    flyway_schema_history.installed_on, which is owned and
--    managed internally by Flyway itself - it is intentionally
--    NOT altered here, since modifying Flyway's own bookkeeping
--    table can break its versioning/checksum tracking.
--    No SQL changes needed for this item.
-- ============================================================