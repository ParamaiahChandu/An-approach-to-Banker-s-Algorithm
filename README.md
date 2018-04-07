# An-approach-to-Banker-s-Algorithm  
A deadlock refers to a specific condition where two or more processes are waiting for release of a resource in a circular chain. Deadlock is a common problem in multiprocessing systems where many processes share a specific type of mutually exclusive resource known as software or soft lock. Deadlocks are particularly troubling because there is no general solution to avoid deadlocks.  
  
A process must request a resource before using it and must release the resource after its use. Each process may request as many resources as it requires to carry out its designated task.  
  
Under the normal mode of operation, a process may utilize a resource in only the following sequence:  
•	Request: The process requests the resource. If the request cannot be granted immediately (for example, if the resource is being used by another process), then the requesting process must wait until it can acquire the resource.  
•	Use: The process can operate on the resource (for example, if the resource is a printer, the process can print on the printer).  
•	Release: The process releases the resource.  
  
The deadlock-avoidance algorithm that shall be presented in this project is Banker’s Algorithm. The name was chosen because the algorithm could be used in a banking system to ensure that the bank never allocated its available cash in such a way that it could no longer satisfy the needs of all its customers.  
  
Banker’s Algorithm:  
We need the following data structures, where n is the number of processes in the system and m is the number of resource types:  
•	Available: A vector of length m indicates the number of available resources of each type. If Available[j] equals k, then k instances of resource type Rj are available.  
•	Max: An n × m matrix defines the maximum demand of each process. If Max[i][j] equals k, then process Pi may request at most k instances of resource type Rj.  
•	Allocation: An n × m matrix defines the number of resources of each type currently allocated to each process. If Allocation[i][j] equals k, then process Pi is currently allocated k instances of resource type Rj.  
•	Need: An n × m matrix indicates the remaining resource need of each process. If Need[i][j] equals k, then process Pi may need k more instances of resource type Rj to complete its task. Note that Need[i][j] equals Max[i][j] − Allocation[i][j].  
  
Safety Algorithm:  
We can now present the algorithm for finding out whether a system is in a safe state. This algorithm is called safety algorithm and can be described as follows:  
1	Let Work and Finish be vectors of length m and n, respectively. Initialize Work = Available and Finish[i] = false for i = 0, 1, ..., n − 1.  
2	Find an index ‘i’ such that both  
  a.	Finish[i] == false  
  b.	Need[i] ≤ Work  
 If no such ‘i’ exists, go to step 4.  
3	Work = Work + Allocation[i] Finish[i] = true  
Go to step 2.  
4	If Finish[i] == true for all i, then the system is in a safe state.  
