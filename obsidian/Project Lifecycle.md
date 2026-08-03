| #   | Actor                               | Step                                                   | Action                                                                                                   | Datastore                                  |
| --- | ----------------------------------- | ------------------------------------------------------ | -------------------------------------------------------------------------------------------------------- | ------------------------------------------ |
| 1   | Shipping Company<br>RPSL (Recuiter) | Declare Berths                                         | Get Data<br>- IMO Number (Vessel)<br>- No. of Berths<br>- No. of Days                                    |                                            |
| 2.1 | System (eNavik)                     | Validation                                             | Information is Accurate<br>Within Regulation                                                             |                                            |
| 2.2 | System (eNavik)                     | Create Berths                                          | 1. Berths created with unique BerthID<br>2. Insert into Allocation Master                                | 1. Berth Master<br>2. Allocation Master    |
| 3   | Student (Trainee)                   | Finishes PreSea Course<br>from DGMA Approved Institute | (Already in Student Master)                                                                              | 1. Student Master                          |
| 4.1 | Shipping Company<br>RPSL (Recuiter) | Submit Contract Details                                | - Student INDoS<br>- Rank<br>- Commencement of Contract<br>- IMO Number (Ship)                           |                                            |
| 4.2 | System (eNavik)                     | Map Contract to Students                               | Save into Contract Master                                                                                | 1. Contract Master                         |
| 5   | Shipping Company<br>RPSL (Recruter) | Sign On Ship & Select Berth                            | - Sign On Date<br>- Enter Port & Country<br>- Select Available Berth                                     | 1. Contract Master<br>2. Allocation Master |
| 6   | System (eNavik)                     | System Assigns Berth to Student                        | - Validate select berth<br>- Allot berth<br>- Update status                                              | 1. Berth Master<br>2. Allocation Master    |
| 7   | Student (Trainee)                   | Student Undergoes / Finishes Training                  | Training In Progress                                                                                     |                                            |
| 8.1 | Shipping Company<br>RPSL (Recuiter) | Sign Off Ship                                          | - Finished on Time<br>- Quits Early<br>- No Show<br>----------------------<br>Training Details Submitted |                                            |
| 8.2 | System (eNavik)                     | System Releases Berth to Pool                          | Berth set back to Available                                                                              | 1. Allocation Master<br>2. Berth Master    |

```sql

Table inventory_transactions {
  id int [pk]
  inventory_batch_id int [not null, ref: > inventory_batches.id]
  change_quantity decimal(10,3) [not null] // negative for deductions, positive for additions
  reason_id int [not null, ref: > inventory_transaction_reasons.id]
  reference_order_id int [ref: > orders.id] // set when reason = order
  created_by int [ref: > users.id]
  created_at timestamp [not null]

  Indexes {
    inventory_batch_id
    reference_order_id
  }
}

```

Ok so here we go with the lifecycle
1. Shipping Company Exists
	1. Make them exist in shipping company master
	2. Shipping Company ID
2. Shipping Company has 'VESSELS'
	1. Make Vessels exists in Vessel master
	2. Vessel has unique IMO number
	3. Vessel has a flag
3. Every Vessel has certain number of 'BERTHS'
	1. Make Berth exists in Berth Master
	2. Berth ID = Ship ID + IMO + Year + Index
	3. Berth has start date
	4. Berth has end date
	5. Berth has available State: Available / Occupied
	6. Berth has student INDoS Number (Optonal / Nullable)
	7. Berth can only be allocated to one student at a time
4. Every Berth can have multiple Allocations
	1. Make Allocation Exist in Allocation Master
	2. Save Contract ID
	3. Save Start Date
	4. Save End Date
	5. Set Status Flag / Update in Berth
5. Student Exist
	1. Add Student in Student Master
	2. INDoS number is a unique id
	3. Student Master has a flag is_pre_sea_course complete?
6. RPSL / Shipping Company creates contract for seafarers
	1. Contract Created in Contract Master
		1. IMO
		2. Rank
		3. Start Date
		4. Student ID / INDoS
	2. Contract Approved / Mapped
		1. Assign BerthID
		2. Assign Start Date
	3. Student Sign On Ship
		1. Update Allocation
		2. Update Berth
		3. Update Contract
		4. Add Start Date
	4. Student Sign Off Ship
		1. Update Allocation
		2. Update Berth
		3. Update Contract
		4. Add End Date