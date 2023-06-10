/*  IBranchRepository.java
    Repository Interface for Branch Domain
    Author: Simphiwe Kahlana (220162891)
    Date: 6 April 2023
 */

package za.ac.cput.vehicledealership.repository;

import za.ac.cput.vehicledealership.domain.Branch;


import java.util.Set;

public interface BranchRepository extends IRepository<Branch, String >{

    Set<Branch> getAll();
}
