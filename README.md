# smartbox
Smart Box is a Component-Container framework. It allows users to create and run applications simply by loading pre-defined components into a container that hosts them.

There are four Component-Based Development roles:

* Container Developer: This role builds the framework, which includes the container and the component base-class.

* Component Developer: This role builds custom components extending the component base-class.

* App Builder: This role uses Smart Box to add specific components to the container and connect them.

* App Launcher: This role uses the application built by the App Builder.

There are two implementation on the smart box.

* Statistics Calculator.

       There are two components: A simple calculator component that implements the ICalculator interface, and a statistics calculator 
       that depends on the ICalculator interface in order to implement its mean method.
* Stack Machine Customization

      stack machine is able to execute basic arithmetic commands such as add, mul, div, and sub. Each of these commands replaces the 
       top two elements of a stack by their sum, produce, quotient, and differences, respectively. In addition, the stack machine can also execute basic stack commands:
     * push arg   // push arg onto the stack where arg is any double
     * pop        // remove top element from the stack
     * pop        // return top element without removing it
     * isEmpty    // return true if the stack is empty
     * clear      // remove all elements from the stack

       
