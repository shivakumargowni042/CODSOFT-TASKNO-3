# MEGA-KART 3D E-Commerce — User & Setup Guide

A complete **3D e-commerce website written 100% in Java** (CODSOFT Internship project).
No Maven, no Spring, no HTML template files — **the Java code generates every page**.
It runs on pure JDK 17 using a built-in HTTP server.

---

## 1. What you need
- **Java 17 or newer** (javac + java on your PATH)
  - Check by running: `java -version`
  - If not installed, install the free **Eclipse Adoptium Temurin JDK 17**.

---

## 2. How to run the website

### Option A — Double-click (easiest)
1. Double-click **`run.bat`**
2. A black console opens with the server message.
3. Open your browser at **http://localhost:8080**

### Option B — From the command line
```bat
cd ecommerce3d
javac -encoding UTF-8 -d out src\*.java
java -cp out src.Server
```
Then open **http://localhost:8080**.

> ⚠️ Keep the console window open — closing it stops the server.

---

## 3. URL map (every page of the site)

| URL | What it shows |
|---|---|
| `/` | 3D animated intro → click **ENTER MEGA-KART** |
| `/shop` | All 31 products |
| `/shop?category=electronics` | Products in one category |
| `/shop?search=laptop` | Search results |
| `/product/{id}` | Single product detail page (e.g. `/product/1`) |
| `/cart` | Your shopping cart |
| `/checkout` | Checkout form (name, email, phone, address) |
| `/checkout-success` | "Order placed" confirmation |
| `/register` | Create a customer account *(new)* |
| `/login` | Login to your account *(new)* |
| `/logout` | Log out *(new)* |
| `/admin/login` | Separate admin login (password protected) *(new)* |
| `/admin/logout` | Log out of the admin dashboard *(new)* |
| `/admin` | **Manage all bookings** (admin only) |
| `/admin/remove/{id}` | Delete one booking |

---

## 4. Files & folders — what contains what

```
ecommerce3d/
│
├── src/                        ← ALL Java source code (the whole app)
│   ├── Server.java             ← THE main program: HTTP server, routing,
│   │                             cart sessions, checkout, saving bookings,
│   │                             loading bookings, admin remove.
│   ├── UI.java                 ← ALL the HTML/CSS/JS as Java strings.
│   │                             Every page is built by a method here:
│   │                               intro()  shop()  product()  cart()
│   │                               checkout() success() admin() notFound()
│   │                             Plus the CSS, app.js and intro.js.
│   ├── ProductService.java     ← The product catalogue data + search/sort logic
│   │                             (31 fake products, all priced in ₹ INR).
│   ├── Product.java            ← Defines what a "Product" is (id, name, price…).
│   ├── Cart.java               ← The shopping cart logic (add/remove/update/total).
│   ├── CartItem.java           ← One row in the cart (a product + quantity).
│   ├── Booking.java            ← Defines what a "Booking/Order" is + its fields.
│   └── User.java               ← Defines a user account (username, email, password, isAdmin).
│
├── orders.json                 ← THE BOOKINGS DATABASE (auto-created on checkout).
│                                 Every customer order is saved here as JSON.
│                                 Survives server restarts. ⭐ SEE SECTION 5.
│
├── users.json                  ← THE ACCOUNTS DATABASE (auto-created on register).
│                                 Every registered user (username, email, hashed-in-demo,
│                                 isAdmin) is saved here. Survives server restarts.
│
├── out/                        ← Compiled .class files (auto-created by javac).
│
└── run.bat                     ← One-click compile + start script.
```

---

## 5. Where your bookings are stored ⭐

Every time a customer completes checkout, the order is **saved to a file**:

**`C:\...\ecommerce3d\orders.json`**

Example of one saved booking:
```json
[{
  "orderId": "MK1788188389223",
  "customerName": "John Doe",
  "customerEmail": "john@example.com",
  "phone": "9988776655",
  "address": "Mumbai",
  "subtotal": 7998.0,
  "gst": 639.84,
  "total": 8637.84,
  "timestamp": 1788188389225,
  "items": [
    {"id": 14, "name": "Memory Foam Pillow Set", "quantity": 1, "price": 5499.0}
  ]
}]
```

**Two ways to view bookings:**

1. **In the browser (recommended):** go to **http://localhost:8080/admin**
   → a table lists every order (name, email, phone, address, date, items, total)
   → a **Revenue** stat shows total sales
   → a **Remove** button deletes an order
2. **In the file:** open **`orders.json`** with Notepad/VS Code.

> Bookings persist across server restarts because they live in `orders.json`.
> Delete the file if you want to start fresh.

---

## 6. Prices & currency
- All prices are in **Indian Rupees (₹)** with Indian comma grouping:
  - ₹1,09,999 (not ₹109,999) — correct Indian format
- **GST is 8%** added to the cart subtotal at checkout.
  - Example: subtotal ₹7,998 → GST ₹639.84 → **total ₹8,637.84**

---

## 7. Managing orders (admin)
The admin dashboard has its **own dedicated login**, separate from customer accounts.

1. Go to **http://localhost:8080/admin** → you are redirected to `/admin/login`.
2. Log in with the admin credentials below.
3. See all bookings, revenue, and each order's items.
4. Delete a booking with its **Remove** button, or click **Logout Admin** to sign out.

**Admin credentials (set in `Server.java`):**

| username | password |
|---|---|
| `admin` | `admin123` |

## 7b. Customer accounts (register / login) *(new)*
- **Register** at `/register`, **Login** at `/login` — customer accounts are stored in `users.json`.
- Once logged in, the top navigation shows your username and a **Logout** button.
- Customer accounts do **not** grant admin access — the admin dashboard only sees the dedicated `/admin/login` credentials above.
- Admin login and customer login are **completely separate systems**.

## 7c. Product descriptions & specifications *(new)*
- Every product page now has **flipkart-style tabs**: **Description | Specifications | Warranty & Returns**.
- Each product includes a long marketing description plus a full specification table (brand, model, battery, material, size, warranty, etc.).
- Search is smarter too — typing "mobile", "phone", "laptop", "shoes", etc. returns relevant products even if the exact word is not in the product name.

---

## 8. Common problems

| Problem | Fix |
|---|---|
| `javac is not recognized` | Install JDK 17 and add `bin` to PATH. |
| Page shows garbled symbols | Always compile with `-encoding UTF-8` (run.bat already does). |
| Port 8080 already in use | Close other server, or change `PORT` in `Server.java`. |
| Cart resets | Orders persist in `orders.json`; the cart itself is per-browser-session (cookie) and is temporary by design. |

---

## 9. Project summary
- **Store name:** MEGA-KART
- **Products:** 31 fake products across categories (Electronics incl. mobiles, Fashion, Home, Sports, Books, Beauty)
- **Feature list:** 3D intro, 3D product cards, search with synonyms, category filter, sort, cart with GST, checkout, customer login/register, separate admin dashboard with its own credentials, flipkart-style product specs
- Built as a **pure Java application** for the CODSOFT internship.

---

## 10. Deploy to the cloud

### Option A — Render (recommended, free)

1. Push this repo to GitHub (see Section 11 below).
2. Go to [render.com](https://render.com), sign in with GitHub.
3. Click **New > Web Service** → select this repo.
4. Render auto-detects the `render.yaml` — click **Apply**.
5. Wait for build + deploy (~2 min). Render gives you a public URL.

### Option B — Docker (any provider)

```bash
docker build -t mega-kart .
docker run -p 8080:8080 mega-kart
```

Works on Railway, Fly.io, AWS ECS, Google Cloud Run, etc.

### Option C — Manual (VPS / cloud VM)

```bash
git clone https://github.com/shivakumargowni042/CODSOFT-TASKNO-3.git
cd CODSOFT-TASKNO-3
javac -encoding UTF-8 -d out src/*.java
java -cp out src.Server
```

---

## 11. Push to GitHub

```bash
cd ecommerce3d
git init
git remote add origin https://github.com/shivakumargowni042/CODSOFT-TASKNO-3.git
git add .
git commit -m "Initial commit: MEGA-KART 3D E-Commerce"
git branch -M main
git push -u origin main
```

### CI/CD
Every push to `main` triggers a **GitHub Actions** workflow (`.github/workflows/build.yml`) that compiles and smoke-tests the server automatically.
