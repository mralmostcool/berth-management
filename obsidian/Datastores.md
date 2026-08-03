
## Berth Master (allocation pool)

| Field      | DataType    | Modifier    | Enum / Values | Foreign Key   |
| ---------- | ----------- | ----------- | ------------- | ------------- |
| id         | UUID        | Primary Key |               |               |
| berth_id   | VARCHAR     | Unique      |               |               |
| vessel_id  | UUID        | Not Null    |               | Vessel Master |
| start_date | Timestamptz |             |               |               |
| end_date   | Timestamptz |             |               |               |

## Contract Master
| Field                    | DataType    | Modifier    | Enum / Values | Foreign Key                                                    |
| ------------------------ | ----------- | ----------- | ------------- | -------------------------------------------------------------- |
| id                       | UUID        | Primary Key |               |                                                                |
| vessel_id (fk)           | UUID        | Not Null    |               | Vessel Master                                                  |
| rank                     | VARCHAR     | Not Null    |               |                                                                |
| commencement_of_contract | TIMESTAMPTZ | Not Null    |               |                                                                |
| student_id (fk)          | UUID        | Not Null    |               | Student Master -> so that we can get access to student details |

## Allocation Master (acts as Berth Logs)

| Field                  | DataType    | Modifier    | Enum / Values | Foreign Key     |
| ---------------------- | ----------- | ----------- | ------------- | --------------- |
| id                     | UUID        | Primary Key |               |                 |
| berth_id (fk)          | UUID        | Not Null    |               | Berth Master    |
| contract_id (fk)       | UUID        | Not Null    |               | Contract Master |
| expected_sign_on_date  | Timestamptz |             |               |                 |
| expected_sign_off_date | Timestamptz |             |               |                 |
| actual_sign_on_date    | Timestamptz |             |               |                 |
| actual_sign_off_date   | Timestamptz |             |               |                 |

## Vessel Master
| Field | DataType     | Modifier    | Enum / Values | Foreign Key |
| ----- | ------------ | ----------- | ------------- | ----------- |
| id    | UUID         | Primary Key |               |             |
| name  | VARCHAR(255) | Not Null    |               |             |
| imo   | VARCHAR(255) | Not Null    |               |             |

## Student Master
| Field | DataType | Modifier    | Enum / Values | Foreign Key |
| ----- | -------- | ----------- | ------------- | ----------- |
| id    | UUID     | Primary Key |               |             |
| name  | VARCHAR  | Not Null    |               |             |
| indos | VARCHAR  | Not Null    |               |             |

## Shipping Company Master
| Field | DataType | Modifier    | Enum / Values | Foreign Key |
| ----- | -------- | ----------- | ------------- | ----------- |
| id    | UUID     | Primary Key |               |             |
| name  | VARCHAR  | Not Null    |               |             |

## Admin Master
| Field | DataType | Modifier    | Enum / Values | Foreign Key |
| ----- | -------- | ----------- | ------------- | ----------- |
| id    | UUID     | Primary Key |               |             |
| name  | VARCHAR  | Not Null    |               |             |

