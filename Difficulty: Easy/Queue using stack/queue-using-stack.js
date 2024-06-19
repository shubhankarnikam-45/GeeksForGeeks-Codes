//{ Driver Code Starts
//Initial Template for javascript

"use strict";

process.stdin.resume();
process.stdin.setEncoding("utf-8");

let inputString = "";
let currentLine = 0;

process.stdin.on("data", (inputStdin) => {
  inputString += inputStdin;
});

process.stdin.on("end", (_) => {
  inputString = inputString
    .trim()
    .split("\n")
    .map((string) => {
      return string.trim();
    });

  main();
});

function readLine() {
  return inputString[currentLine++];
}

/* Function to print an array */
function printArray(arr, size) {
  let i;
  let s = "";
  for (i = 0; i < size; i++) {
    if(arr[i] == -0)
      arr[i] = 0;
    s += arr[i] + " ";
  }
  console.log(s);
}

function main() {
  let t = parseInt(readLine());
  let i = 0;
  for (; i < t; i++) {
    let ob = new Queue();
    let Q = parseInt(readLine());
    let s = "";
    let qs = readLine().split(" ").map((x)=>parseInt(x));
    let j = 0;
    while(j<qs.length){
      if(qs[j]===1){
        let x = qs[j+1];
        j++;
        ob.enqueue(x);
      }else{
       s=s+ob.dequeue()+" "; 
      }
      j++;
    }
    console.log(s);
  }
}
// } Driver Code Ends


//User function Template for javascript

class Queue {
  constructor(){
      
      //initialize the two stacks.
      this.stack1 = [];
      this.stack2 = [];
  }

/**
 * @param {number} x
 */
  enqueue(x){
      //code here
      this.stack1.push(x);
  }

/**
 * @return {number}
 */
  dequeue(){
      
      //this condition wherw our stack is exmpty.
      if(this.stack1.length == 0)
      return -1;
      
      //we adding first stack to second.
      while(this.stack1.length > 0)
      {
          this.stack2.push(this.stack1.pop());
      }
      
      //pop element and return
      let toBeReturn = this.stack2.pop();
      
      while(this.stack2.length > 0 )
      {
          this.stack1.push(this.stack2.pop());
      }
      
      return toBeReturn;
      
      
  }
}
