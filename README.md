<h1>Inventory Project</h1>

<h2>Overview</h2>
<p>This is an inventory program that can be used for storing CDs and DVDs.
The <em>language</em> used for the program is <strong>Object-Oriented Programming</strong>, therefore
there are 2 classes:</p>
<ul> 
<li><em>the driver class</em>: <strong>ProductTester</strong>, which is in charge of running the object class</li> 
<li><em>the object class</em>: <strong>Product</strong></li>
<li><em>2 subclasses of the Product superclass</em>: <strong>DVD</strong> and <strong>CD</strong></li>
</ul>

<h2>Features</h2>
<ul>
<li>Adding products to the inventory depending on its type</li>
<li>Viewing products that are stored</li>
<li>Add to/Remove from the number of units in stock for a certain product</li>
<li>Discontinue product sale</li>
<li>Implementing a user interface: a <strong>MENU</strong> the user can choose from what changes to apply to the inventory</li>
</ul>

<h2>OOP concepts used</h2>
<ul>
<li><strong>Abstraction</strong>: the Product class is abstract to avoid creating pure Product objects, only DVD and CD objects are needed.</li>
<li><strong>Encapsulation</strong>: in the Product class the instance fields are declared as <em>private</em>.</li>
<li><strong>Inheritance</strong>: by creating subclasses of the Product class; the DVD and CD subclasses <em>inherit</em> the public methods/getters/setters from the Product
parent class, the fields from the superclass are not inherited because they are private, but they can be accessed through the public getters.</li>
<li><strong>Polymorphism</strong>: when creating CD or DVD objects instead of a generic product object; DVD and CD subclasses 
define their own unique behaviours (<em>overriding methods</em>: getInventoryValue, toString) and yet share some of the same functionality of the Product class.
Also, <em>Dynamic Method Dispatch</em> is the mechanism by which a call to an overridden method is resolved at run time, rather than compile time.
At run time, it depends on the <strong>type of the object being referred to</strong> (not the <strong>type of the reference variable</strong>)</li>
</ul>

<h2>Other concepts used</h2>
<ul>
<li>The use of <strong>static methods</strong> in the <strong>driver class</strong> in order to make the code <em>more modular, easier to read and understand</em></li>
</ul>

<h2>Inspiration</h2>
<p>This personal project was inspired by the <strong>JF Java Fundamentals Learner course on ORACLE Academy</strong>. It was made for learning purposes.</p>
<p><img alt="Source Material" title="Java Fundamentals" src="Java_Fundamentals.png"/></p>

<h2>How to compile and run the project in terminal</h2>
<ul>
<li>For compiling the project use command in terminal from the <em>src</em> directory:<br> <strong>javac inventory/ProductTester.java inventory/Product.java</strong></li>
<li>For running the project use command in terminal from the <em>src</em> directory:<br> <strong>java inventory.ProductTester</strong></li>
</ul>