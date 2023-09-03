/*  BranchService.java
    Service Interface for Branch Domain
    Author: Simphiwe Kahlana (220162891)
    Date: 09 June 2023
*/

package za.ac.cput.vehicledealership.service;


import za.ac.cput.vehicledealership.domain.Branch;

import java.util.List;
import java.util.Set;

public interface BranchService extends IService<Branch, Integer> {
    List<Branch> getAll();

}
