package src;

import java.util.*;
import java.util.stream.Collectors;

public class ProductService {
    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        loadFakeData();
    }

    private void loadFakeData() {
        products.add(new Product(1, "Pro Max Headphones",
            "Wireless noise-cancelling headphones with 40hr battery life and premium sound quality",
            "Immerse yourself in studio-grade sound with the SoundWave Pro Max Headphones. Featuring advanced active noise cancellation that blocks out up to 95% of ambient noise, plush memory-foam ear cushions for all-day comfort, and a stunning 40-hour battery life — your music never has to stop. The custom-tuned 50mm drivers deliver deep, punchy bass, crystal-clear mids, and sparkling highs for a truly premium listening experience.",
            Product.specs(new String[][]{
                {"Brand", "SoundWave"},
                {"Model Name", "Pro Max"},
                {"Form Factor", "Over-Ear"},
                {"Connectivity", "Bluetooth 5.3, 3.5mm AUX, USB-C"},
                {"Driver Size", "50mm Dynamic"},
                {"Noise Cancellation", "Active ANC (up to -35dB)"},
                {"Battery Life", "40 hours (ANC on)"},
                {"Charging", "USB-C Fast Charge (10 min = 5 hrs)"},
                {"Microphone", "Built-in dual mic + ENC"},
                {"Weight", "285 g"},
                {"Warranty", "2 Years"},
            }),
            24999, 32999, "electronics", "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=400&h=400&fit=crop", 4.8, 2341, true, "SoundWave", 25.0));

        products.add(new Product(2, "Ultra Slim Laptop 15\"",
            "Intel i7 13th Gen, 16GB RAM, 512GB SSD, 4K OLED Display",
            "The TechNova Ultra Slim Laptop redefines portable power. Powered by the latest Intel Core i7 13th Gen processor and 16GB of fast RAM, it breezes through multitasking, coding, and 4K video editing. The stunning 15-inch 4K OLED display delivers rich, true-to-life colours with perfect blacks, while the premium aluminium body stays incredibly thin and light. With a 512GB NVMe SSD and all-day battery, this is the ultimate productivity machine.",
            Product.specs(new String[][]{
                {"Brand", "TechNova"},
                {"Processor", "Intel Core i7-13700H (13th Gen)"},
                {"RAM", "16GB DDR5 (5200MHz)"},
                {"Storage", "512GB NVMe SSD"},
                {"Display", "15.6\" 4K OLED, 100% DCI-P3"},
                {"Graphics", "Intel Iris Xe"},
                {"Operating System", "Windows 11 Home"},
                {"Ports", "2x USB-C, 2x USB-A, HDMI, SD"},
                {"Battery", "76Wh, up to 12 hours"},
                {"Weight", "1.38 kg"},
                {"Warranty", "1 Year Onsite"},
            }),
            109999, 134999, "electronics", "https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=400&h=400&fit=crop", 4.7, 1856, true, "TechNova", 18.8));

        products.add(new Product(3, "Smart Watch Pro",
            "Health tracking, GPS, 7-day battery, waterproof 50m",
            "The ChronoTech Smart Watch Pro puts a personal health lab on your wrist. Track your heart rate, SpO2, sleep, and stress around the clock with clinical-grade sensors. Built-in dual-band GPS maps your runs and rides accurately, while the bright AMOLED display stays readable even in direct sunlight. Waterproof to 50 metres and boasting a remarkable 7-day battery life, it keeps up with your most active days.",
            Product.specs(new String[][]{
                {"Brand", "ChronoTech"},
                {"Display", "1.43\" AMOLED, 466x466"},
                {"Health Sensors", "Heart rate, SpO2, ECG, temperature"},
                {"Water Resistance", "5 ATM (50m)"},
                {"GPS", "Dual-band GPS + GLONASS"},
                {"Battery", "7 days (typical)"},
                {"Sports Modes", "120+ workout modes"},
                {"Connectivity", "Bluetooth 5.3, WiFi"},
                {"Compatibility", "Android & iOS"},
                {"Warranty", "1 Year"},
            }),
            28999, 36999, "electronics", "https://images.unsplash.com/photo-1523275335684-37898b6baf30?w=400&h=400&fit=crop", 4.6, 3102, true, "ChronoTech", 22.2));

        products.add(new Product(4, "4K Action Camera",
            "Waterproof 4K60fps, image stabilization, WiFi",
            "Capture every adrenaline-filled moment in stunning 4K with the VividShot Action Camera. Shoot buttery-smooth 4K60fps footage with advanced electronic image stabilization that keeps your videos steady even on the roughest terrain. Waterproof up to 30 metres without a case, with a rugged design that survives drops, dust, and extreme weather. Built-in WiFi makes sharing your adventures to your phone effortless.",
            Product.specs(new String[][]{
                {"Brand", "VividShot"},
                {"Video Resolution", "4K@60fps, 1080p@120fps"},
                {"Sensor", "1/2.3\" CMOS 20MP"},
                {"Image Stabilization", "6-axis EIS"},
                {"Waterproof", "30m (no case)"},
                {"Field of View", "170° ultra-wide"},
                {"Display", "2.0\" Touchscreen"},
                {"Storage", "microSD up to 256GB"},
                {"Connectivity", "WiFi + Bluetooth"},
                {"Battery", "1350mAh, removable"},
            }),
            16999, 23999, "electronics", "https://images.unsplash.com/photo-1526170375885-4d8ecf77b99f?w=400&h=400&fit=crop", 4.5, 987, true, "VividShot", 28.6));

        products.add(new Product(5, "Wireless Earbuds Mini",
            "True wireless, touch controls, deep bass, 30hr total",
            "Big sound, tiny size. The SoundWave Earbuds Mini deliver surprisingly deep bass and balanced audio from ultra-compact buds that fit comfortably in any ear. Touch controls let you manage calls and music with a tap, while the pocketable charging case extends total playback to an impressive 30 hours. With IPX5 water resistance, they are perfect for workouts and commutes alike.",
            Product.specs(new String[][]{
                {"Brand", "SoundWave"},
                {"Sound", "10mm dynamic drivers"},
                {"Bluetooth", "5.3, low latency"},
                {"Total Playtime", "30 hrs (with case)"},
                {"Per-Charge", "6 hours"},
                {"Charging", "USB-C + wireless"},
                {"Water Resistance", "IPX5"},
                {"Controls", "Touch, voice assistant"},
                {"Noise", "ENC for calls"},
                {"Warranty", "1 Year"},
            }),
            6499, 10499, "electronics", "https://images.unsplash.com/photo-1590658268037-6bf12f032f55?w=400&h=400&fit=crop", 4.4, 4521, true, "SoundWave", 38.5));

        products.add(new Product(6, "Designer Leather Jacket",
            "Premium Italian leather, modern slim fit, black",
            "Turn heads with the UrbanStyle Designer Leather Jacket. Crafted from genuine premium Italian lambskin leather, it offers an unmatched combination of softness, durability, and style. The modern slim-fit silhouette hugs your frame while the quilted lining keeps you warm. Whether you are riding, partying, or heading to the office, this iconic black jacket elevates every outfit to the next level.",
            Product.specs(new String[][]{
                {"Brand", "UrbanStyle"},
                {"Material", "100% Genuine Lamb Leather"},
                {"Lining", "Quilted satin"},
                {"Fit", "Slim fit"},
                {"Colour", "Classic Black"},
                {"Closure", "YKK front zip"},
                {"Pockets", "4 exterior, 2 interior"},
                {"Care", "Professional leather clean"},
                {"Sizes", "S to XXL"},
            }),
            19999, 31999, "fashion", "https://images.unsplash.com/photo-1551028719-00167b16eac5?w=400&h=400&fit=crop", 4.7, 876, true, "UrbanStyle", 37.5));

        products.add(new Product(7, "Classic Running Sneakers",
            "Lightweight mesh, responsive cushioning, neon green",
            "Chase your personal best in the StrideMax Classic Running Sneakers. The engineered breathable mesh keeps your feet cool and light, while the responsive EVA cushioning absorbs impact and returns energy with every stride. A high-traction rubber outsole grips wet and dry surfaces alike, and the neon accents add a bold pop of colour to your run. Designed for everyday comfort from your first km to your last.",
            Product.specs(new String[][]{
                {"Brand", "StrideMax"},
                {"Upper", "Breathable engineered mesh"},
                {"Cushioning", "Responsive EVA midsole"},
                {"Outsole", "High-traction rubber"},
                {"Heel Drop", "8mm"},
                {"Weight", "245 g (per shoe)"},
                {"Colour", "Neon Green / Black"},
                {"Ideal For", "Running, gym, casual"},
                {"Sizes", "UK 6 to 12"},
            }),
            10999, 14999, "fashion", "https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=400&h=400&fit=crop", 4.6, 2134, true, "StrideMax", 27.8));

        products.add(new Product(8, "Premium Denim Jeans",
            "Stretch comfort, classic blue, slim straight fit",
            "The DenimCo Premium Jeans combine timeless style with all-day comfort. Made from premium stretch denim that moves with you, they offer a clean slim-straight fit that flatters without restricting. The classic indigo blue finishes easily with anything, and reinforced stitching ensures they last wash after wash. A wardrobe essential that never goes out of style.",
            Product.specs(new String[][]{
                {"Brand", "DenimCo"},
                {"Fabric", "98% Cotton, 2% Spandex stretch"},
                {"Fit", "Slim straight"},
                {"Colour", "Classic Indigo"},
                {"Rise", "Mid-rise"},
                {"Closure", "Button fly"},
                {"Wash", "Machine wash cold"},
                {"Lengths", "30\", 32\", 34\""},
                {"Sizes", "28 to 40"},
            }),
            7499, 9999, "fashion", "https://images.unsplash.com/photo-1542272604-787c3835535d?w=400&h=400&fit=crop", 4.5, 1567, true, "DenimCo", 25.0));

        products.add(new Product(9, "Luxury Chronograph Watch",
            "Swiss movement, sapphire crystal, steel band",
            "Add timeless precision to your wrist with the ChronoTech Luxury Chronograph. Powered by a genuine Swiss quartz movement, it keeps flawless time for years. The scratch-proof sapphire crystal protects a sleek dial, while the brushed stainless steel case and bracelet deliver a premium weight and feel. A date window and three chronograph sub-dials complete this sophisticated piece that works from boardroom to black-tie.",
            Product.specs(new String[][]{
                {"Brand", "ChronoTech"},
                {"Movement", "Swiss quartz chronograph"},
                {"Crystal", "Scratch-resistant sapphire"},
                {"Case", "Stainless steel, 42mm"},
                {"Band", "Stainless steel bracelet"},
                {"Water Resistance", "10 ATM (100m)"},
                {"Dial", "Black with date window"},
                {"Features", "Chronograph, date"},
                {"Warranty", "2 Years"},
            }),
            49999, 74999, "fashion", "https://images.unsplash.com/photo-1524592094714-0f0654e20314?w=400&h=400&fit=crop", 4.9, 654, true, "ChronoTech", 33.3));

        products.add(new Product(10, "Vintage Sunglasses",
            "Polarized UV400, titanium frame, retro aviator",
            "Protect your eyes in retro style with the LuxeVision Vintage Aviator Sunglasses. Featuring polarized UV400 lenses that cut glare and block 100% of harmful UVA/UVB rays, they keep your vision crisp and comfortable in bright sun. The feather-light titanium frame is both durable and corrosion-resistant, while the classic aviator shape flatters every face. Includes a premium hard case and microfiber pouch.",
            Product.specs(new String[][]{
                {"Brand", "LuxeVision"},
                {"Lens", "Polarized, UV400"},
                {"Frame", "Titanium"},
                {"Shape", "Retro Aviator"},
                {"Lens Width", "58mm"},
                {"Includes", "Hard case + cleaning cloth"},
                {"Weight", "18 g"},
                {"Ideal For", "Driving, travel, fashion"},
            }),
            12999, 17999, "fashion", "https://images.unsplash.com/photo-1572635196237-14b3f281503f?w=400&h=400&fit=crop", 4.4, 1023, true, "LuxeVision", 27.3));

        products.add(new Product(11, "Smart LED Floor Lamp",
            "RGB colors, voice control, dimmable, modern arc",
            "Transform any room with the BrightHome Smart LED Floor Lamp. Its elegant arc design casts a warm or cool glow across your living space, with 16 million RGB colours and adjustable brightness to set the perfect mood. Control it by voice with Alexa or Google Assistant, or from your phone via the app. Create schedules, scenes, and sync to your music for an immersive atmosphere.",
            Product.specs(new String[][]{
                {"Brand", "BrightHome"},
                {"Light Source", "LED, 16M RGB colours"},
                {"Brightness", "Dimmable, up to 1800 lumens"},
                {"Control", "App, Alexa, Google Assistant"},
                {"Voltage", "100-240V"},
                {"Design", "Modern arc"},
                {"Height", "165 cm"},
                {"Warranty", "1 Year"},
            }),
            11999, 15999, "home", "https://images.unsplash.com/photo-1507473885765-e6ed057ab6fe?w=400&h=400&fit=crop", 4.6, 1892, true, "BrightHome", 25.0));

        products.add(new Product(12, "Ergonomic Office Chair",
            "Lumbar support, adjustable arms, mesh back, headrest",
            "Work comfortably for hours with the ComfortPro Ergonomic Office Chair. The breathable mesh back offers adaptive lumbar support that conforms to your spine, while the adjustable headrest and 4D armrests let you dial in the perfect position. A smooth-rolling base with lockable casters and a weight-rated, height-adjustable gas lift ensure stability on any floor. Your back will thank you.",
            Product.specs(new String[][]{
                {"Brand", "ComfortPro"},
                {"Backrest", "Breathable mesh, curved"},
                {"Lumbar", "Adjustable"},
                {"Armrests", "4D adjustable"},
                {"Headrest", "Height & angle adjustable"},
                {"Seat", "High-density foam, fabric"},
                {"Weight Capacity", "150 kg"},
                {"Tilt", "Rocking with tension lock"},
                {"Warranty", "3 Years"},
            }),
            32999, 44999, "home", "https://images.unsplash.com/photo-1592078615290-033ee584e267?w=400&h=400&fit=crop", 4.8, 3245, true, "ComfortPro", 27.3));

        products.add(new Product(13, "Artisan Coffee Machine",
            "Espresso, cappuccino, latte, built-in grinder",
            "Brew café-quality coffee in your own kitchen with the BrewMaster Artisan Coffee Machine. The built-in conical burr grinder delivers freshly ground beans for every cup, while the 15-bar Italian pump extracts rich, aromatic espresso. With one-touch programmes for espresso, cappuccino, and latte, plus a milk frother that creates velvety microfoam, you can craft barista drinks effortlessly every morning.",
            Product.specs(new String[][]{
                {"Brand", "BrewMaster"},
                {"Type", "Automatic espresso machine"},
                {"Pump", "15-bar Italian"},
                {"Grinder", "Built-in conical burr"},
                {"Drinks", "Espresso, cappuccino, latte, americano"},
                {"Milk Frother", "Steam wand + auto"},
                {"Water Tank", "2.0L removable"},
                {"Bean Hopper", "250g"},
                {"Warranty", "2 Years"},
            }),
            39999, 55999, "home", "https://images.unsplash.com/photo-1517668808822-9ebb02f2a0e6?w=400&h=400&fit=crop", 4.7, 1456, true, "BrewMaster", 28.6));

        products.add(new Product(14, "Memory Foam Pillow Set",
            "Cooling gel, adjustable loft, hypoallergenic pair",
            "Wake up refreshed with the DreamRest Memory Foam Pillow Set. The adaptive memory foam cradles your head and neck in perfect alignment, while the cooling gel layer keeps you cool through the night. An adjustable loft lets you remove filling for a custom height, and the hypoallergenic, washable cover is kind to sensitive skin. Sold as a set of two for you and your partner.",
            Product.specs(new String[][]{
                {"Brand", "DreamRest"},
                {"Material", "Cooling gel memory foam"},
                {"Set Includes", "2 pillows"},
                {"Loft", "Adjustable"},
                {"Cover", "Hypoallergenic, washable"},
                {"Size", "60 x 40 x 12 cm"},
                {"Firmness", "Medium"},
                {"Care", "Removable washable cover"},
            }),
            5499, 7999, "home", "https://images.unsplash.com/photo-1584100936595-c0654b55a2e2?w=400&h=400&fit=crop", 4.5, 2678, true, "DreamRest", 30.0));

        products.add(new Product(15, "Minimalist Wall Clock",
            "Silent movement, oversized 14in, Scandinavian oak",
            "Add understated style to any wall with the TimeCraft Minimalist Clock. The oversized 14-inch face in natural Scandinavian oak brings warmth and clean lines to your space. Its ultra-quiet sweep movement means no annoying ticking — just beautiful, accurate time. Perfect for living rooms, offices, and cafés that value sophisticated simplicity.",
            Product.specs(new String[][]{
                {"Brand", "TimeCraft"},
                {"Diameter", "14 inches"},
                {"Material", "Scandinavian oak"},
                {"Movement", "Ultra-quiet sweep"},
                {"Colour", "Natural wood"},
                {"Power", "1 AA battery"},
                {"Mounting", "Wall bracket included"},
            }),
            3999, 6499, "home", "https://images.unsplash.com/photo-1563861826100-9cb868fdbe1c?w=400&h=400&fit=crop", 4.3, 876, true, "TimeCraft", 37.5));

        products.add(new Product(16, "Smart Fitness Tracker",
            "Heart rate, sleep tracking, 50+ sports modes",
            "Take your training to the next level with the FitPulse Smart Fitness Tracker. It tracks your heart rate 24/7, monitors sleep stages, and offers 50+ sports modes to match your routine. The always-on AMOLED display shows your stats at a glance, while smart notifications keep you connected. With a 14-day battery life and 5 ATM water resistance, it is built for relentless daily use.",
            Product.specs(new String[][]{
                {"Brand", "FitPulse"},
                {"Display", "1.62\" AMOLED, always-on"},
                {"Sensors", "Optical HR, SpO2, accelerometer"},
                {"Sports Modes", "50+"},
                {"Battery", "Up to 14 days"},
                {"Water Resistance", "5 ATM"},
                {"Notifications", "Calls, SMS, apps"},
                {"Compatibility", "Android & iOS"},
            }),
            7499, 10999, "sports", "https://images.unsplash.com/photo-1575311373937-040b8e1fd5b6?w=400&h=400&fit=crop", 4.5, 3456, true, "FitPulse", 30.8));

        products.add(new Product(17, "Carbon Fiber Bike",
            "Lightweight 8kg frame, 21-speed, disc brakes",
            "Experience the thrill of feather-light speed with the VeloMax Carbon Fiber Bike. The full carbon frame tips the scales at just 8kg, making climbs effortless and sprints explosive. A reliable 21-speed drivetrain lets you find the perfect gear on any terrain, while powerful hydraulic disc brakes give you confident stopping power in all weather. A superb choice for serious riders and weekend enthusiasts alike.",
            Product.specs(new String[][]{
                {"Brand", "VeloMax"},
                {"Frame", "Full carbon fiber, 8kg"},
                {"Gears", "21-speed"},
                {"Brakes", "Hydraulic disc"},
                {"Wheels", "700c alloy"},
                {"Fork", "Carbon, vibration dampening"},
                {"Ideal For", "Road & fitness riding"},
                {"Assembly", "85% pre-assembled"},
            }),
            74999, 99999, "sports", "https://images.unsplash.com/photo-1485965120184-e220f721d03e?w=400&h=400&fit=crop", 4.8, 543, true, "VeloMax", 25.0));

        products.add(new Product(18, "Yoga Mat Premium",
            "Non-slip, 6mm thick, eco-friendly with strap",
            "Find your flow on the ZenFit Premium Yoga Mat. Its textured non-slip surface keeps you firmly planted through the sweatiest session, while the generously padded 6mm thickness cushions your joints. Made from eco-friendly TPE material free of toxic PVC, it is safe for you and the planet. A matching carry strap makes it effortless to take your practice anywhere.",
            Product.specs(new String[][]{
                {"Brand", "ZenFit"},
                {"Material", "Eco-friendly TPE"},
                {"Thickness", "6mm"},
                {"Size", "183 x 61 cm"},
                {"Non-slip", "Textured dual-layer"},
                {"Includes", "Carry strap"},
                {"Care", "Wipe clean, air dry"},
                {"Weight", "1.2 kg"},
            }),
            2999, 4499, "sports", "https://images.unsplash.com/photo-1601925260368-ae2f83cf8b7f?w=400&h=400&fit=crop", 4.4, 4321, true, "ZenFit", 33.3));

        products.add(new Product(19, "Adjustable Dumbbell Set",
            "5-50 lbs, quick-change mechanism, space saving",
            "Build strength at home without sacrificing space with the IronGrip Adjustable Dumbbell Set. A quick-change dial lets you switch from 5 to 50 lbs in seconds, replacing an entire rack of weights with a single pair. The knurled steel handles and durable vinyl plates provide a secure, comfortable grip. Compact and built to last, they are perfect for every home gym.",
            Product.specs(new String[][]{
                {"Brand", "IronGrip"},
                {"Weight Range", "5 - 50 lbs per dumbbell"},
                {"Adjustment", "Quick-change dial"},
                {"Plates", "Durable vinyl-coated steel"},
                {"Handle", "Knurled steel"},
                {"Includes", "2 dumbbells + tray"},
                {"Space Saving", "Replaces full rack"},
            }),
            24999, 35999, "sports", "https://images.unsplash.com/photo-1638536532686-d610adfc8e5c?w=400&h=400&fit=crop", 4.7, 1234, true, "IronGrip", 30.0));

        products.add(new Product(20, "Smart Water Bottle",
            "Temperature display, 24hr insulation, 750ml LED",
            "Stay hydrated smarter with the HydroSmart Smart Water Bottle. A bright LED display on the lid shows your water temperature and reminds you to drink on schedule. Double-wall vacuum insulation keeps drinks ice-cold for 24 hours or hot for 12. The leak-proof 750ml design fits most cup holders and backpack pockets — your ideal hydration companion.",
            Product.specs(new String[][]{
                {"Brand", "HydroSmart"},
                {"Capacity", "750 ml"},
                {"Insulation", "Double-wall vacuum"},
                {"Cold/Hot", "Cold 24h, Hot 12h"},
                {"Display", "LED temperature + reminders"},
                {"Material", "BPA-free stainless steel"},
                {"Lid", "Leak-proof with loop"},
                {"Care", "Hand wash recommended"},
            }),
            2499, 3799, "sports", "https://images.unsplash.com/photo-1602143407151-7111542de6e8?w=400&h=400&fit=crop", 4.3, 5678, true, "HydroSmart", 33.3));

        products.add(new Product(21, "The Art of Programming",
            "Complete guide to modern software development",
            "Master the craft of software engineering with 'The Art of Programming'. This comprehensive guide takes you from core coding fundamentals to advanced system design, clean code, and testing practices used by professionals worldwide. Packed with real-world examples, hands-on exercises, and insider tips, it is the definitive resource for both beginners and experienced developers who want to level up.",
            Product.specs(new String[][]{
                {"Author", "Rega Choppala"},
                {"Pages", "480"},
                {"Language", "English"},
                {"Edition", "2nd Edition (2025)"},
                {"Binding", "Paperback"},
                {"Publisher", "CodePress"},
                {"ISBN", "978-1-11-234567-8"},
                {"Includes", "Online code repository"},
            }),
            3499, 4699, "books", "https://images.unsplash.com/photo-1544716278-ca5e3f4abd8c?w=400&h=400&fit=crop", 4.8, 2345, true, "CodePress", 25.0));

        products.add(new Product(22, "AI & Machine Learning",
            "From basics to advanced neural networks explained",
            "Demystify artificial intelligence with 'AI & Machine Learning'. This accessible yet thorough book walks you from the fundamentals of statistics and models to building, training, and deploying advanced neural networks. With clear diagrams, practical Python projects, and real case studies, it empowers you to understand and create intelligent systems that solve real problems.",
            Product.specs(new String[][]{
                {"Author", "Dr. Kavya Rao"},
                {"Pages", "520"},
                {"Language", "English"},
                {"Edition", "Latest (2026)"},
                {"Binding", "Hardcover"},
                {"Publisher", "TechBooks"},
                {"Projects", "Python, TensorFlow, PyTorch"},
                {"Level", "Beginner to Advanced"},
            }),
            4299, 5799, "books", "https://images.unsplash.com/photo-1532012197267-da84d127e765?w=400&h=400&fit=crop", 4.7, 1876, true, "TechBooks", 26.7));

        products.add(new Product(23, "Design Systems Handbook",
            "Building scalable UI component libraries",
            "Design better, build faster with the 'Design Systems Handbook'. Learn how to architect scalable UI component libraries, establish consistent design tokens, and document patterns that keep product teams in sync. Featuring interviews with designers from leading tech companies and actionable frameworks, it is the essential guide for designers and developers building great products at scale.",
            Product.specs(new String[][]{
                {"Author", "Ananya Iyer"},
                {"Pages", "360"},
                {"Language", "English"},
                {"Edition", "1st Edition"},
                {"Binding", "Paperback"},
                {"Publisher", "DesignPress"},
                {"Includes", "Figma templates"},
                {"Audience", "Designers & front-end devs"},
            }),
            2999, 4199, "books", "https://images.unsplash.com/photo-1589829085413-56de8ae18c73?w=400&h=400&fit=crop", 4.6, 987, true, "DesignPress", 27.3));

        products.add(new Product(24, "Startup Playbook",
            "Proven strategies for building successful companies",
            "Turn your big idea into a thriving company with the 'Startup Playbook'. Distilling lessons from hundreds of founders, this book covers validated strategies for idea testing, funding, go-to-market, hiring, and growth. Filled with honest stories of both wins and failures, it is the practical, no-nonsense blueprint every aspiring entrepreneur needs to navigate the journey from zero to scale.",
            Product.specs(new String[][]{
                {"Author", "Vikram Shah"},
                {"Pages", "300"},
                {"Language", "English"},
                {"Edition", "Revised Edition"},
                {"Binding", "Paperback"},
                {"Publisher", "VentureBooks"},
                {"Includes", "Templates & checklists"},
                {"Audience", "Founders & entrepreneurs"},
            }),
            2499, 3299, "books", "https://images.unsplash.com/photo-1512820790803-83ca734da794?w=400&h=400&fit=crop", 4.5, 3210, true, "VentureBooks", 25.0));

        products.add(new Product(25, "Vitamin C Serum",
            "Anti-aging, brightening, organic ingredients 30ml",
            "Unlock a radiant complexion with the GlowLab Vitamin C Serum. Formulated with 15% stabilized Vitamin C, this powerful antioxidant serum brightens dull skin, fades dark spots, and boosts collagen for a firmer, more youthful look. Infused with hyaluronic acid and vitamin E, it deeply hydrates while protecting against environmental damage. Suitable for all skin types, gentle enough for daily use.",
            Product.specs(new String[][]{
                {"Brand", "GlowLab"},
                {"Volume", "30 ml"},
                {"Key Ingredient", "15% Stabilized Vitamin C"},
                {"Other Actives", "Hyaluronic acid, Vitamin E"},
                {"Skin Type", "All skin types"},
                {"Texture", "Lightweight serum"},
                {"Usage", "Daily, morning or night"},
                {"Cruelty Free", "Yes, 100% vegan"},
            }),
            2699, 3899, "beauty", "https://images.unsplash.com/photo-1620916566398-39f1143ab7be?w=400&h=400&fit=crop", 4.7, 5432, true, "GlowLab", 30.0));

        products.add(new Product(26, "Professional Hair Dryer",
            "Ionic technology, 3 heat settings, diffuser included",
            "Salon-quality hair styling at home with the StylePro Professional Hair Dryer. Ionic technology reduces frizz and static for smooth, shiny results, while a powerful yet quiet motor dries hair fast. Choose from 3 heat and 2 speed settings to suit your hair type, and finish with curls or volume using the included diffuser. Lightweight and comfortable to hold, it makes every styling session effortless.",
            Product.specs(new String[][]{
                {"Brand", "StylePro"},
                {"Motor", "High-speed professional"},
                {"Technology", "Ionic (reduce frizz)"},
                {"Heat Settings", "3"},
                {"Speed Settings", "2"},
                {"Included", "Concentrator + diffuser"},
                {"Power", "1800W"},
                {"Weight", "480 g"},
                {"Warranty", "2 Years"},
            }),
            6999, 10199, "beauty", "https://images.unsplash.com/photo-1522338242992-e1a54571a7d8?w=400&h=400&fit=crop", 4.6, 2345, true, "StylePro", 30.8));

        products.add(new Product(27, "Skincare Gift Set",
            "Cleanser, toner, moisturizer, SPF 50 - luxury box",
            "Give the gift of glowing skin with the GlowLab Luxury Skincare Gift Set. This complete regime includes a gentle cleanser, balancing toner, hydrating moisturizer, and SPF 50 sunscreen — everything needed for a flawless daily routine. Packaged in an elegant, reusable gift box, each formula is dermatologist-tested and free from parabens and sulphates. The perfect present for anyone who loves self-care.",
            Product.specs(new String[][]{
                {"Brand", "GlowLab"},
                {"Contents", "Cleanser, Toner, Moisturizer, SPF 50"},
                {"Volume", "4 x 30 ml travel set"},
                {"Skin Type", "All skin types"},
                {"Free From", "Parabens, sulphates, cruelty"},
                {"Packaging", "Luxury reusable gift box"},
                {"Tested", "Dermatologist tested"},
            }),
            6499, 9699, "beauty", "https://images.unsplash.com/photo-1556228578-0d85b1a4d571?w=400&h=400&fit=crop", 4.8, 1567, true, "GlowLab", 33.3));

        products.add(new Product(28, "Galaxy Pro 5G Smartphone",
            "6.7\" AMOLED, 128GB, 50MP triple camera, 5000mAh",
            "Step into the future with the Galaxy Pro 5G Smartphone. Its stunning 6.7-inch AMOLED display brings movies and games to life with vivid colours and a silky 120Hz refresh rate. Powered by a fast octa-core processor and 8GB RAM, it handles any app effortlessly. The 50MP triple-camera system captures stunning photos day or night, and the massive 5000mAh battery with fast charging keeps you going all day. With 128GB of storage and true 5G speed, it is built to keep up with you.",
            Product.specs(new String[][]{
                {"Brand", "Galaxy"},
                {"Display", "6.7\" AMOLED, 120Hz"},
                {"Processor", "Octa-core 2.8GHz"},
                {"RAM", "8GB"},
                {"Storage", "128GB (expandable)"},
                {"Camera", "50MP + 8MP + 2MP triple"},
                {"Front Camera", "16MP"},
                {"Battery", "5000mAh, 33W fast charge"},
                {"Network", "5G, Dual SIM"},
                {"OS", "Android 14"},
                {"Warranty", "1 Year"},
            }),
            34999, 42999, "electronics", "https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?w=400&h=400&fit=crop", 4.7, 4512, true, "Galaxy", 18.6));

        products.add(new Product(29, "Pixel XR Smartphone",
            "6.5\" OLED, 256GB, AI camera, 48hr battery",
            "Photography lovers, meet the Pixel XR Smartphone. The advanced AI camera uses computational photography to deliver jaw-dropping shots in any light, from stunning night mode to crisp portraits. The bright 6.5-inch OLED display is perfect for streaming and gaming, while the long-lasting battery pushes an incredible 48 hours between charges. With 256GB of storage, exclusive Google software, and guaranteed OS updates, the Pixel XR is the smartest phone in its class.",
            Product.specs(new String[][]{
                {"Brand", "Pixel"},
                {"Display", "6.5\" OLED, 90Hz"},
                {"Processor", "Google Tensor G3"},
                {"RAM", "12GB"},
                {"Storage", "256GB"},
                {"Camera", "50MP AI dual-camera"},
                {"Front Camera", "13MP"},
                {"Battery", "48 hours, 30W fast charge"},
                {"Network", "5G, eSIM + Nano"},
                {"OS", "Android 15"},
                {"Warranty", "1 Year"},
            }),
            45999, 52999, "electronics", "https://images.unsplash.com/photo-1598327105666-5b89351aff97?w=400&h=400&fit=crop", 4.8, 2103, true, "Pixel", 13.2));

        products.add(new Product(30, "Nova Flip Smartphone",
            "Foldable 6.9\" AMOLED, 256GB, slim design",
            "Experience the future of mobility with the Nova Flip Smartphone. This sleek foldable opens into a generous 6.9-inch AMOLED display and folds down to pocket-size for effortless carrying. The crease-resistant hinge feels premium and lasts for 400,000 folds, while the powerful chipset and 256GB of storage handle anything you throw at it. Capture vivid photos with the dual camera and enjoy all-day battery in a truly innovative design.",
            Product.specs(new String[][]{
                {"Brand", "Nova"},
                {"Display", "6.9\" AMOLED foldable + 3.4\" cover"},
                {"Processor", "Snapdragon 8 Gen 2"},
                {"RAM", "12GB"},
                {"Storage", "256GB"},
                {"Camera", "50MP dual"},
                {"Front Camera", "32MP"},
                {"Battery", "4400mAh, 67W fast charge"},
                {"Hinge", "400,000 fold cycles"},
                {"OS", "Android 14"},
                {"Warranty", "1 Year"},
            }),
            78999, 94999, "electronics", "https://images.unsplash.com/photo-1610945265064-0e34e5519bbf?w=400&h=400&fit=crop", 4.6, 987, true, "Nova", 17.0));

        products.add(new Product(31, "Phone Accessory Combo",
            "Fast charger, USB-C cable 2m, tempered glass, case",
            "Get everything you need in one box with the Phone Accessory Combo. The 20W fast charger refuels your phone in minutes, while the durable 2-metre USB-C cable reaches anywhere. A flexible protective case and pre-cut tempered glass screen guard keep your device looking brand new. The complete starter kit for any new smartphone.",
            Product.specs(new String[][]{
                {"Brand", "GearUp"},
                {"Charger", "20W USB-C fast charger"},
                {"Cable", "USB-C 2m, braided"},
                {"Case", "Flexible TPU"},
                {"Screen Guard", "Pre-cut tempered glass"},
                {"Compatibility", "Universal Android/iOS"},
            }),
            1499, 2499, "electronics", "https://images.unsplash.com/photo-1585060544812-6b45742d762f?w=400&h=400&fit=crop", 4.3, 3210, true, "GearUp", 40.0));
    }

    public List<Product> getAll() { return products; }

    public Product getById(long id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public List<Product> getByCategory(String category) {
        if (category == null || category.isEmpty() || category.equalsIgnoreCase("all")) return products;
        return products.stream().filter(p -> p.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());
    }

    public List<Product> search(String query) {
        if (query == null || query.trim().isEmpty()) return products;
        String q = query.toLowerCase().trim();
        String[] terms = normalize(q).split("\\s+");
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            String hay = normalize(p.getName() + " " + p.getBrand() + " " + p.getCategory() + " " + p.getDescription());
            boolean match = true;
            for (String t : terms) {
                if (!t.isEmpty() && !hay.contains(t)) { match = false; break; }
            }
            if (match) result.add(p);
        }
        return result;
    }

    private String normalize(String s) {
        return s.toLowerCase()
            .replace("smartphone", " phone mobile")
            .replace("smart phones", " phone mobile")
            .replace("mobile", " phone mobile")
            .replace("phones", " phone mobile")
            .replace("laptops", " laptop")
            .replace("headphones", " headphone earphone audio")
            .replace("earbuds", " earbud audio earphone")
            .replace("watches", " watch")
            .replace("shoes", " shoe sneaker")
            .replace("sneakers", " shoe sneaker")
            .replace("jeans", " jean")
            .replace("tvs", " tv")
            .replace("electronics", " electronic gadget")
            .replace("fashion", " clothes shoe style")
            .replace("beauty", " skin care")
            .replace("home", " home living furnishing")
            .replace("sports", " sport fitness gym")
            .replace("books", " book read")
            .trim();
    }

    public List<String> getCategories() {
        return products.stream().map(Product::getCategory).distinct().collect(Collectors.toList());
    }

    public List<Product> getFeatured() {
        return products.stream().filter(p -> p.getRating() >= 4.6).limit(6).collect(Collectors.toList());
    }

    public List<Product> getDeals() {
        return products.stream().filter(p -> p.getDiscount() >= 25).collect(Collectors.toList());
    }

    public List<Product> getBySearchOrCategory(String search, String category) {
        if (search != null && !search.trim().isEmpty()) return search(search);
        return getByCategory(category);
    }
}
