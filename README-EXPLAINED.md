# MEGA-KART 3D E-Commerce — Explained Like You Are 10 Years Old

This second README teaches you **how the whole website works**, one simple step at a time —
the ideas, the code, and the concepts. By the end you will be able to explain MEGA-KART
to anyone, and understand what each Java file is doing.

---

## The Big Idea First

Imagine you are running a shop from your bedroom, but instead of a physical shop, your
shop is **a program your computer runs**. Customers open a **web browser** (like Chrome),
type a web address, and see your shop. They add toys to a cart, type their address, and
"buy" — and you see their order on your **ADMIN desk** where you keep a notebook of orders.

- The "notebook" is a file called **`orders.json`**.
- The "shop" is your **Java program**.
- The "web address" is **http://localhost:8080**.

---

## Concepts You Need to Understand

### 1. The Web = "Question and Answer"
When a browser asks your program a question, your program sends back an **answer**.

- Question (request): *"Please show me the shop page."* -> GET `/shop`
- Answer (response): a full web page (HTML) that the browser draws.

Your Java program is the **server** — it listens and answers all day long.

### 2. What HTML, CSS and JavaScript are
- **HTML** = the *skeleton* of a page (headings, buttons, pictures).
- **CSS** = the *clothes and makeup* (colors, sizes, cool 3D tilt effects).
- **JavaScript** = the *muscles and brain in the browser* (animations, the spinning 3D cube).

Special trick of this project: we write **all three INSIDE Java strings**
(in `UI.java`). You never edit an HTML file — you edit Java.

### 3. What "Pure Java" means
Many websites use helper tools (like Spring Boot or Maven). MEGA-KART uses **none**.
It uses only the tools that come **built into Java** — not even one extra library.
That's what "pure Java application" means: **everything in this app is just Java.**

---

## The Parts (Files) and Their Jobs

Think of the project like building blocks.

| File | What it is | In real-life words |
|---|---|---|
| `Server.java` | **The Boss / Store Manager** | Runs everything, answers every web question, saves orders. |
| `UI.java` | **The Decorator / Artist** | Draws every page. Holds all HTML, CSS, JS. |
| `ProductService.java` | **The Stock Room** | Holds the 31 products, their specs, and finds them. |
| `Product.java` | **The Blueprint of one toy** | Says a product has: id, name, long description, specs, price, etc. |
| `Cart.java` | **The Shopping Basket** | Adds/removes items and totals the price. |
| `CartItem.java` | **One item inside the basket** | Product + how many. |
| `Booking.java` | **The Order Slip** | One customer order: name, address, total, items. |
| `User.java` | **The Customer Card** | One customer account: username, email, password. |
| `orders.json` | **The Order Notebook (file)** | All bookings saved on disk. |
| `users.json` | **The Customer List (file)** | All registered customer accounts saved on disk. |
| `run.bat` | **The Start Button** | Compiles and starts the app. |

---

## How a Customer Buys Something (Step by Step)

Let's follow one customer named **Priya** from mouse click to order.

### Step 1 — Priya opens the Intro
- Browser asks: **GET /**
- `Server.java` calls `UI.intro()` -> returns the animated 3D landing page.
- Priya clicks **ENTER MEGA-KART**.

### Step 2 — Priya browses the Shop
- Browser asks: **GET /shop**
- `Server.java` asks `ProductService` for the products, then calls `UI.shop(...)` to draw the page.
- Each product is drawn as a card (that tilts in 3D when you move the mouse — that's the CSS/JS).

### Step 3 — Priya searches "mobile"
- Browser asks: **GET /shop?search=mobile**
- `Server.java` passes the word to `ProductService.search("mobile")`, which looks through
  every product's name, brand, category, and description (plus synonyms) and returns the matches.

### Step 4 — Priya opens a product
- Browser asks: **GET /product/1**
- `UI.product(...)` draws the page with **tabs**: Description, Specifications, Warranty & Returns.
- The Specifications tab shows a table like on Flipkart (brand, battery, material, etc.).

### Step 5 — Priya adds a toy to the cart
- Browser asks: **GET /cart/add/5**
- `Server.java` finds that cart (via a **cookie** ~ a little nametag the browser keeps)
  and calls `cart.addItem(product)`.

> **Concept: Cookie / Session**
> A cookie is a tiny label your browser saves, so the server remembers *which* cart is
> yours. Without it, everyone would share one basket!

### Step 6 — Priya checks out
- Browser asks: **GET /checkout** -> shows the address form.
- Priya fills in name, email, phone, address and presses "Place Order".
- Browser sends that info as a **POST** (like filling out a paper form).

### Step 7 — The order is saved
- `Server.java` builds a `Booking` object with Priya's details + the cart items.
- It calls `saveOrders()` -> writes to **`orders.json`**.
- It clears Priya's cart and shows the **success** page.

### Step 8 — The owner checks the ADMIN desk
- The owner goes to **GET /admin** -> redirected to **/admin/login**.
- The owner logs in with special admin credentials.
- `Server.java` reads all bookings and `UI.admin(...)` draws a table showing
  them, plus the total **Revenue**.

That's the whole cycle!

---

## Admin Access — Separate From Customer Login

- **Customers** register/login at `/register` and `/login` (saved in `users.json`).
- The **Admin dashboard** (`/admin`) has its **own separate login** at `/admin/login`.
- Even a normal logged-in customer cannot see the admin dashboard — it needs the
  dedicated admin username and password.
- The admin credentials are stored in `Server.java` (default `admin` / `admin123`).

---

## Famous Code Explained in Kid Words

### Where the server listens (Server.java)
```java
public static void main(String[] args) {
    HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
    server.createContext("/", Server::handleRequest);   // answer everything here
    server.start();
}
```
- `PORT` = the door number (8080).
- `createContext("/", ...)` = "answer EVERY URL using handleRequest".
- `handleRequest` is the giant **switchboard** that reads the URL and decides the answer.

### The switchboard (Server.java)
```java
if (path.equals("/shop"))        handleShop(...);
else if (path.equals("/cart"))   handleCartPage(...);
else if (path.equals("/admin"))  handleAdmin(...);
```
It's like a robot that asks: *"What did the browser ask for? Then do the right thing."*

### Drawing a page (UI.java)
```java
public static String shop(String title, List<Product> products, ...) {
    return "<html>... " + title + " ..." + products ... ;  // a big string of HTML
}
```
`UI.java` builds a giant **text string** of HTML and hands it back to the server.
The browser then draws that text as a pretty page.

### The stock room (ProductService.java)
```java
public Product getById(long id) {
    // returns the product that has this exact id
}
```
This is how `/product/5` finds the 5th product.

### The basket (Cart.java)
```java
public double getTotal() {
    return items.values().stream()
        .mapToDouble(CartItem::getTotalPrice).sum();   // add up everything
}
```
`getTotal()` adds the price x quantity of every item in the basket.

### The order slip (Booking.java)
```java
public Booking(String orderId, String customerName, ... , double total) {
    this.orderId = orderId;
    ...
    this.total = total;
    this.timestamp = System.currentTimeMillis();  // today's date & time
}
```
A `Booking` object carries one full order. `timestamp` records the moment it was made.

### Saving the notebook (Server.java)
```java
private static void saveOrders() {
    // write every booking to orders.json as JSON text
}
```
"JSON" is just a neat text format computers use to store data — look at `orders.json`
to see it.

---

## The Cool 3D Stuff (JavaScript/CSS)

This is all inside `UI.java` as strings:

- **3D intro cube** — a scene (like a mini game) that renders a cube with the letters
  MEGA-KART and a starfield background. It uses the CSS `transform` + JavaScript animation.
- **Floating product cards** — `transform: perspective() rotateX() rotateY()` makes cards
  tilt toward your mouse. This is "3D" in CSS.
- **Glassmorphism** — the pretty see-through glass look.

---

## Request vs Response — One More Time
- **Request** = what the browser wants (the question).
- **Response** = what your Java program sends back (HTML page / data).

`handleRequest` in `Server.java` is the middleman that matches each question to an answer.

---

## Quick "Explain It in One Minute" Script

> "MEGA-KART is an online store made ONLY with Java. There is a server program
> (Server.java) that answers the browser. When you open a page it asks ProductService
> for products and UI.java draws the HTML. Each product has a full description and a
> specifications table like Flipkart. When you buy something it saves your order to
> orders.json, and the store owner logs into a separate admin page to see all bookings.
> There are no HTML files at all — Java creates every page. Everything runs on the
> built-in JDK with no extra tools."

---

## Quiz (Test Yourself!)
1. Which file draws all the web pages? -> `UI.java`
2. Which file holds the 31 products? -> `ProductService.java`
3. Where are bookings saved? -> `orders.json`
4. What does a *cookie* do? -> Remembers which cart is yours.
5. What does `/admin` show? -> All customer bookings + revenue.
6. What is GST? -> An 8% tax added at checkout.
7. Why is it "pure Java"? -> No Spring, no Maven, no HTML files — just JDK.
8. Where is the separate admin login? -> `/admin/login` (with its own password)

---

Now go explain MEGA-KART like a pro!
