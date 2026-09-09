package src;

import java.util.*;

/**
 * UI.java — All HTML/CSS/JS is generated here in pure Java.
 * No .html/.css/.js template files are needed at runtime.
 */
public class UI {

    public static String CSS = """
        *{margin:0;padding:0;box-sizing:border-box}
        :root{--primary:#7c3aed;--primary-light:#a78bfa;--primary-dark:#5b21b6;--accent:#06b6d4;--accent2:#f43f5e;--bg:#0a0a0f;--bg2:#111118;--bg3:#1a1a24;--text:#e2e8f0;--text2:#94a3b8;--glass:rgba(255,255,255,0.05);--glass-border:rgba(255,255,255,0.08)}
        body{background:var(--bg);color:var(--text);font-family:'Rajdhani',sans-serif;overflow-x:hidden;line-height:1.6}
        a{text-decoration:none;color:inherit}
        ::-webkit-scrollbar{width:8px}::-webkit-scrollbar-track{background:var(--bg2)}::-webkit-scrollbar-thumb{background:var(--primary-dark);border-radius:4px}
        .navbar{position:fixed;top:0;left:0;right:0;z-index:1000;padding:0.8rem 2rem;backdrop-filter:blur(20px);background:rgba(10,10,15,0.85);border-bottom:1px solid var(--glass-border);transition:all 0.3s ease}
        .navbar.scrolled{padding:0.5rem 2rem;box-shadow:0 5px 30px rgba(0,0,0,0.5)}
        .nav-inner{max-width:1400px;margin:0 auto;display:flex;align-items:center;gap:2rem}
        .nav-logo{font-family:'Orbitron',sans-serif;font-size:1.5rem;font-weight:900;letter-spacing:2px;white-space:nowrap}
        .logo-n{background:linear-gradient(135deg,var(--primary-light),var(--accent));-webkit-background-clip:text;-webkit-text-fill-color:transparent;background-clip:text}
        .logo-3d{font-size:0.8em;color:var(--accent);margin-left:2px}
        .nav-search{flex:1;max-width:500px;position:relative}
        .search-form{display:flex;background:var(--glass);border:1px solid var(--glass-border);border-radius:50px;overflow:hidden;transition:all 0.3s ease}
        .search-form:focus-within{border-color:var(--primary);box-shadow:0 0 20px rgba(124,58,237,0.2)}
        .search-input{flex:1;background:transparent;border:none;padding:0.7rem 1.2rem;color:var(--text);font-family:'Rajdhani',sans-serif;font-size:1rem;outline:none}
        .search-input::placeholder{color:var(--text2)}
        .search-btn{background:transparent;border:none;padding:0.7rem 1rem;color:var(--text2);cursor:pointer;transition:color 0.3s}
        .search-btn:hover{color:var(--primary-light)}
        .nav-actions{display:flex;align-items:center;gap:1.5rem}
        .nav-link{font-weight:600;font-size:1rem;padding:0.4rem 1rem;border-radius:8px;transition:all 0.3s}
        .user-chip{color:var(--primary-light);background:rgba(124,58,237,0.12);border:1px solid rgba(124,58,237,0.3);white-space:nowrap}        .nav-link:hover,.nav-link.active{color:var(--primary-light);background:rgba(124,58,237,0.1)}
        .cart-link{position:relative;color:var(--text);transition:color 0.3s}
        .cart-link:hover,.active-cart{color:var(--primary-light)}
        .cart-badge{position:absolute;top:-8px;right:-10px;background:var(--accent2);color:#fff;font-size:0.7rem;font-weight:700;width:20px;height:20px;border-radius:50%;display:flex;align-items:center;justify-content:center;animation:pulse 2s infinite}
        @keyframes pulse{0%,100%{transform:scale(1)}50%{transform:scale(1.15)}}
        .hero-section{min-height:88vh;display:flex;align-items:center;justify-content:center;position:relative;overflow:hidden;padding:6rem 2rem 4rem}
        .hero-bg{position:absolute;inset:0;z-index:0}
        .hero-orb{position:absolute;border-radius:50%;filter:blur(80px);animation:orb-float 8s ease-in-out infinite}
        .orb-1{width:400px;height:400px;background:rgba(124,58,237,0.15);top:10%;left:10%}
        .orb-2{width:350px;height:350px;background:rgba(6,182,212,0.12);bottom:10%;right:15%;animation-delay:-3s}
        .orb-3{width:300px;height:300px;background:rgba(244,63,94,0.1);top:50%;left:50%;animation-delay:-5s}
        @keyframes orb-float{0%,100%{transform:translate(0,0)}33%{transform:translate(30px,-30px)}66%{transform:translate(-20px,20px)}}
        .hero-content{position:relative;z-index:1;text-align:center;max-width:800px}
        .hero-title{font-family:'Orbitron',sans-serif;font-size:4rem;font-weight:900;line-height:1.1;margin-bottom:1.5rem}
        .hero-line{display:block;opacity:0;transform:translateY(30px);animation:hero-slide 0.8s ease forwards}
        .hero-line:nth-child(1){animation-delay:0.2s}.hero-line:nth-child(2){animation-delay:0.4s}.hero-line:nth-child(3){animation-delay:0.6s}
        @keyframes hero-slide{to{opacity:1;transform:translateY(0)}}
        .gradient-text{background:linear-gradient(135deg,var(--primary-light),var(--accent),var(--accent2));-webkit-background-clip:text;-webkit-text-fill-color:transparent;background-clip:text}
        .hero-sub{font-size:1.3rem;color:var(--text2);margin-bottom:3rem;opacity:0;animation:hero-slide 0.8s ease forwards 0.8s}
        .hero-stats{display:flex;gap:3rem;justify-content:center;opacity:0;animation:hero-slide 0.8s ease forwards 1s}
        .stat-item{text-align:center}
        .stat-num{display:block;font-family:'Orbitron',sans-serif;font-size:2.5rem;font-weight:700;color:var(--primary-light)}
        .stat-label{font-size:0.9rem;color:var(--text2);text-transform:uppercase;letter-spacing:2px}
        .categories-section{padding:4rem 2rem;max-width:1400px;margin:0 auto}
        .section-header{text-align:center;margin-bottom:3rem}
        .section-title{font-family:'Orbitron',sans-serif;font-size:2.5rem;font-weight:700;margin-bottom:0.5rem}
        .title-underline{width:60px;height:3px;background:linear-gradient(90deg,var(--primary),var(--accent));margin:0 auto;border-radius:2px}
        .categories-grid{display:grid;grid-template-columns:repeat(auto-fit,minmax(160px,1fr));gap:1.5rem}
        .cat-card{background:var(--glass);border:1px solid var(--glass-border);border-radius:16px;padding:2rem 1rem;text-align:center;display:flex;flex-direction:column;align-items:center;gap:0.8rem;transition:all 0.4s cubic-bezier(0.175,0.885,0.32,1.275);cursor:pointer}
        .cat-card:hover,.cat-card.active{transform:translateY(-8px) scale(1.03);border-color:var(--primary);background:rgba(124,58,237,0.1);box-shadow:0 15px 40px rgba(124,58,237,0.2)}
        .cat-icon{font-size:2.5rem;transition:transform 0.3s}
        .cat-card:hover .cat-icon{transform:scale(1.2) rotate(5deg)}
        .products-section{padding:3rem 2rem 5rem;max-width:1400px;margin:0 auto}
        .sort-controls{margin-top:1rem}
        .sort-select{background:var(--glass);border:1px solid var(--glass-border);color:var(--text);padding:0.5rem 1rem;border-radius:8px;font-family:'Rajdhani',sans-serif;font-size:0.95rem;cursor:pointer;outline:none}
        .products-grid{display:grid;grid-template-columns:repeat(auto-fill,minmax(280px,1fr));gap:2rem;margin-top:2rem}
        .product-card{perspective:1000px}
        .card-3d-wrapper{background:var(--bg2);border:1px solid var(--glass-border);border-radius:16px;overflow:hidden;transition:all 0.4s cubic-bezier(0.175,0.885,0.32,1.275);transform-style:preserve-3d;position:relative}
        .card-3d-wrapper:hover{transform:translateY(-10px) rotateX(3deg) rotateY(-2deg);box-shadow:0 25px 50px rgba(124,58,237,0.25);border-color:var(--primary)}
        .card-image{position:relative;overflow:hidden;aspect-ratio:1/1}
        .card-image img{width:100%;height:100%;object-fit:cover;transition:transform 0.5s ease}
        .card-3d-wrapper:hover .card-image img{transform:scale(1.1) rotate(2deg)}
        .card-badge{position:absolute;top:12px;left:12px;background:var(--accent2);color:#fff;padding:0.3rem 0.7rem;border-radius:20px;font-size:0.8rem;font-weight:700;z-index:2}
        .card-overlay{position:absolute;inset:0;background:rgba(10,10,15,0.7);display:flex;align-items:center;justify-content:center;opacity:0;transition:opacity 0.3s}
        .card-3d-wrapper:hover .card-overlay{opacity:1}
        .quick-view{padding:0.6rem 1.5rem;border:1px solid var(--primary-light);border-radius:30px;color:var(--primary-light);font-weight:600;transform:translateY(10px);transition:all 0.3s}
        .card-3d-wrapper:hover .quick-view{transform:translateY(0)}
        .card-body{padding:1.2rem}
        .card-brand{font-size:0.8rem;color:var(--accent);text-transform:uppercase;letter-spacing:1px;font-weight:600}
        .card-title{font-size:1.1rem;font-weight:600;margin:0.3rem 0;white-space:nowrap;overflow:hidden;text-overflow:ellipsis}
        .card-rating{display:flex;align-items:center;gap:0.5rem;margin:0.5rem 0}
        .stars{display:flex;gap:2px}
        .star{color:var(--text2);font-size:0.85rem}
        .star.filled{color:#fbbf24}
        .review-count{color:var(--text2);font-size:0.8rem}
        .card-price{display:flex;align-items:center;gap:0.8rem;margin-top:0.5rem}
        .current-price{font-family:'Orbitron',sans-serif;font-size:1.2rem;font-weight:700;color:var(--primary-light)}
        .original-price{font-size:0.95rem;color:var(--text2);text-decoration:line-through}
        .card-actions{padding:0 1.2rem 1.2rem}
        .add-to-cart-btn{width:100%;padding:0.7rem;background:linear-gradient(135deg,var(--primary),var(--primary-dark));color:#fff;border:none;border-radius:10px;cursor:pointer;font-family:'Rajdhani',sans-serif;font-size:0.95rem;font-weight:600;display:flex;align-items:center;justify-content:center;gap:0.5rem;transition:all 0.3s;opacity:0;transform:translateY(10px)}
        .card-3d-wrapper:hover .add-to-cart-btn{opacity:1;transform:translateY(0)}
        .add-to-cart-btn:hover{background:linear-gradient(135deg,var(--primary-light),var(--primary));box-shadow:0 5px 20px rgba(124,58,237,0.4)}
        .btn-primary{display:inline-block;padding:0.8rem 2rem;background:linear-gradient(135deg,var(--primary),var(--primary-dark));color:#fff;border-radius:10px;font-weight:600;transition:all 0.3s}
        .btn-primary:hover{transform:translateY(-2px);box-shadow:0 10px 30px rgba(124,58,237,0.4)}
        .deals-section{padding:3rem 2rem 5rem;max-width:1400px;margin:0 auto}
        .deals-carousel{display:grid;grid-template-columns:repeat(auto-fill,minmax(280px,1fr));gap:1.5rem;margin-top:2rem}
        .deal-card{background:linear-gradient(135deg,rgba(244,63,94,0.08),rgba(124,58,237,0.08));border:1px solid rgba(244,63,94,0.2);border-radius:16px;overflow:hidden;transition:all 0.4s ease}
        .deal-card:hover{transform:translateY(-5px);box-shadow:0 15px 40px rgba(244,63,94,0.15)}
        .deal-image{position:relative;aspect-ratio:16/10;overflow:hidden}
        .deal-image img{width:100%;height:100%;object-fit:cover;transition:transform 0.5s}
        .deal-card:hover .deal-image img{transform:scale(1.05)}
        .deal-badge{position:absolute;top:12px;right:12px;background:var(--accent2);color:#fff;padding:0.4rem 0.8rem;border-radius:8px;font-weight:700;font-size:0.85rem}
        .deal-info{padding:1.2rem}
        .deal-info h3{font-size:1.1rem;margin-bottom:0.5rem}
        .deal-prices{display:flex;align-items:center;gap:0.8rem;margin-bottom:1rem}
        .deal-now{font-family:'Orbitron',sans-serif;font-size:1.3rem;font-weight:700;color:var(--accent2)}
        .deal-was{font-size:1rem;color:var(--text2);text-decoration:line-through}
        .deal-btn{display:block;text-align:center;padding:0.7rem;background:linear-gradient(135deg,var(--accent2),#e11d48);color:#fff;border:none;border-radius:10px;font-family:'Rajdhani',sans-serif;font-size:1rem;font-weight:700;cursor:pointer;transition:all 0.3s}
        .deal-btn:hover{transform:scale(1.02);box-shadow:0 5px 20px rgba(244,63,94,0.4)}
        .breadcrumb{padding:6rem 2rem 1rem;max-width:1400px;margin:0 auto;font-size:0.9rem;color:var(--text2)}
        .breadcrumb a{color:var(--primary-light)}
        .product-detail-section{padding:2rem 2rem 5rem;max-width:1400px;margin:0 auto}
        .product-detail-grid{display:grid;grid-template-columns:1fr 1fr;gap:4rem;align-items:start}
        .detail-image-container{position:sticky;top:100px}
        .detail-image-3d{position:relative;border-radius:20px;overflow:hidden;transform:perspective(1000px) rotateY(-5deg);transition:transform 0.5s ease;border:1px solid var(--glass-border)}
        .detail-image-3d:hover{transform:perspective(1000px) rotateY(0deg)}
        .detail-img{width:100%;aspect-ratio:1/1;object-fit:cover}
        .image-glow{position:absolute;inset:0;background:radial-gradient(circle at 30% 30%,rgba(124,58,237,0.2),transparent 70%);pointer-events:none}
        .detail-brand{color:var(--accent);text-transform:uppercase;letter-spacing:2px;font-weight:600;font-size:0.9rem}
        .detail-name{font-family:'Orbitron',sans-serif;font-size:2.2rem;font-weight:700;margin:0.5rem 0 1rem}
        .detail-rating{display:flex;align-items:center;gap:0.8rem;margin-bottom:1.5rem}
        .rating-num{font-weight:700;font-size:1.1rem}
        .detail-price-block{display:flex;align-items:center;gap:1rem;margin-bottom:1.5rem;flex-wrap:wrap}
        .detail-price{font-family:'Orbitron',sans-serif;font-size:2.5rem;font-weight:900;color:var(--primary-light)}
        .detail-original{font-size:1.3rem;color:var(--text2);text-decoration:line-through;visibility:visible}
        .detail-discount{background:rgba(244,63,94,0.15);color:var(--accent2);padding:0.3rem 0.8rem;border-radius:8px;font-weight:700;font-size:0.9rem}
        .detail-desc{color:var(--text2);font-size:1.1rem;line-height:1.8;margin-bottom:1.5rem}
        .detail-stock{display:flex;align-items:center;gap:0.5rem;font-weight:600;margin-bottom:2rem}
        .stock-dot{width:10px;height:10px;border-radius:50%;animation:pulse 2s infinite}
        .in-stock{color:#22c55e}.in-stock .stock-dot{background:#22c55e}
        .out-stock{color:var(--accent2)}.out-stock .stock-dot{background:var(--accent2)}
        .detail-actions{display:flex;gap:1rem;margin-bottom:2rem;flex-wrap:wrap}
        .btn-add-cart-large{padding:1rem 2.5rem;background:linear-gradient(135deg,var(--primary),var(--primary-dark));color:#fff;border:none;border-radius:12px;font-family:'Rajdhani',sans-serif;font-size:1.1rem;font-weight:700;cursor:pointer;display:flex;align-items:center;gap:0.7rem;transition:all 0.3s}
        .btn-add-cart-large:hover{transform:translateY(-2px);box-shadow:0 10px 30px rgba(124,58,237,0.4)}
        .btn-continue{padding:1rem 2rem;background:var(--glass);border:1px solid var(--glass-border);border-radius:12px;color:var(--text);font-weight:600;transition:all 0.3s;display:flex;align-items:center}
        .btn-continue:hover{border-color:var(--primary);background:rgba(124,58,237,0.1)}
        .detail-features{display:grid;grid-template-columns:repeat(2,1fr);gap:1rem;margin-top:1rem}
        .feature{display:flex;align-items:center;gap:0.5rem;padding:0.8rem;background:var(--glass);border-radius:10px;border:1px solid var(--glass-border);font-size:0.9rem}
        .detail-sections{max-width:1400px;margin:0 auto;padding:1rem 2rem 5rem}
        .detail-tabs{display:flex;gap:0.5rem;border-bottom:2px solid var(--glass-border);margin-bottom:2rem;flex-wrap:wrap}
        .detail-tab{background:none;border:none;color:var(--text2);font-family:'Rajdhani',sans-serif;font-size:1.05rem;font-weight:700;padding:0.8rem 1.5rem;cursor:pointer;border-bottom:2px solid transparent;margin-bottom:-2px;transition:all 0.3s}
        .detail-tab:hover{color:var(--primary-light)}
        .detail-tab.active{color:var(--primary-light);border-bottom-color:var(--primary)}
        .detail-tab-content{background:var(--bg2);border:1px solid var(--glass-border);border-radius:16px;padding:2rem}
        .detail-section-title{font-family:'Orbitron',sans-serif;font-size:1.4rem;margin-bottom:1.2rem;color:var(--primary-light)}
        .long-desc{color:var(--text);font-size:1.1rem;line-height:1.9;max-width:900px}
        .spec-table{width:100%;border-collapse:collapse}
        .spec-table td{padding:0.9rem 1rem;border-bottom:1px solid var(--glass-border);vertical-align:top}
        .spec-table tr:last-child td{border-bottom:none}
        .spec-table .spec-name{font-weight:700;color:var(--text2);width:40%;background:rgba(124,58,237,0.05)}
        .warranty-list{padding-left:1.2rem;color:var(--text);font-size:1.05rem;line-height:2.2}
        .cart-section{padding:7rem 2rem 5rem;max-width:1200px;margin:0 auto}
        .cart-header{display:flex;align-items:center;justify-content:space-between;margin-bottom:2rem}
        .cart-title{font-family:'Orbitron',sans-serif;font-size:2rem;font-weight:700}
        .cart-count{color:var(--text2)}
        .empty-cart{text-align:center;padding:5rem 0}
        .empty-cart-icon{color:var(--text2);margin-bottom:1.5rem;animation:float 3s ease-in-out infinite}
        @keyframes float{0%,100%{transform:translateY(0)}50%{transform:translateY(-15px)}}
        .empty-cart h2{font-family:'Orbitron',sans-serif;font-size:1.5rem;margin-bottom:0.5rem}
        .empty-cart p{color:var(--text2);margin-bottom:2rem}
        .cart-content{display:grid;grid-template-columns:1fr 380px;gap:2rem;align-items:start}
        .cart-items{display:flex;flex-direction:column;gap:1rem}
        .cart-item{display:flex;align-items:center;gap:1.5rem;padding:1.2rem;background:var(--bg2);border:1px solid var(--glass-border);border-radius:16px;transition:all 0.3s}
        .cart-item:hover{border-color:var(--primary);transform:translateX(5px)}
        .item-image{width:90px;height:90px;border-radius:12px;overflow:hidden;flex-shrink:0}
        .item-image img{width:100%;height:100%;object-fit:cover}
        .item-details{flex:1;display:flex;flex-direction:column;gap:0.2rem}
        .item-name{font-weight:600;font-size:1.05rem;transition:color 0.2s}
        .item-name:hover{color:var(--primary-light)}
        .item-brand{font-size:0.8rem;color:var(--accent);text-transform:uppercase;letter-spacing:1px}
        .item-price-unit{font-size:0.85rem;color:var(--text2)}
        .item-quantity{display:flex;align-items:center;gap:0.3rem}
        .qty-form{display:flex;align-items:center;gap:0.3rem}
        .qty-btn{width:32px;height:32px;border:1px solid var(--glass-border);background:var(--glass);color:var(--text);border-radius:8px;cursor:pointer;font-size:1rem;display:flex;align-items:center;justify-content:center;transition:all 0.2s;text-decoration:none;line-height:32px}
        .qty-btn:hover{border-color:var(--primary);background:rgba(124,58,237,0.1)}
        .qty-num{font-weight:700;font-size:1.1rem;width:30px;text-align:center}
        .item-total{font-family:'Orbitron',sans-serif;font-weight:700;font-size:1.1rem;color:var(--primary-light);min-width:80px;text-align:right}
        .remove-btn{background:none;border:none;color:var(--text2);cursor:pointer;padding:0.5rem;transition:color 0.2s;border-radius:8px;display:flex;align-items:center}
        .remove-btn:hover{color:var(--accent2);background:rgba(244,63,94,0.1)}
        .cart-summary{background:var(--bg2);border:1px solid var(--glass-border);border-radius:16px;padding:2rem;position:sticky;top:100px}
        .cart-summary h3{font-family:'Orbitron',sans-serif;font-size:1.3rem;margin-bottom:1.5rem}
        .summary-row{display:flex;justify-content:space-between;margin-bottom:0.8rem;font-size:1rem}
        .free-shipping{color:#22c55e;font-weight:600}
        .summary-divider{border-top:1px solid var(--glass-border);margin:1rem 0}
        .summary-row.total{font-size:1.3rem;font-weight:700}
        .summary-row.total span:last-child{font-family:'Orbitron',sans-serif;color:var(--primary-light)}
        .checkout-btn{width:100%;padding:1rem;background:linear-gradient(135deg,var(--primary),var(--primary-dark));color:#fff;border:none;border-radius:12px;font-family:'Rajdhani',sans-serif;font-size:1.1rem;font-weight:700;cursor:pointer;margin-top:1.5rem;transition:all 0.3s}
        .checkout-btn:hover{transform:translateY(-2px);box-shadow:0 10px 30px rgba(124,58,237,0.4)}
        .continue-link{display:block;text-align:center;margin-top:1rem;color:var(--primary-light);font-weight:600}
        .footer{background:var(--bg2);border-top:1px solid var(--glass-border);padding:4rem 2rem 0;margin-top:3rem}
        .footer-grid{max-width:1400px;margin:0 auto;display:grid;grid-template-columns:2fr 1fr 1fr 1fr;gap:3rem;padding-bottom:3rem}
        .footer-col h3{font-family:'Orbitron',sans-serif;font-size:1.3rem;margin-bottom:1rem}
        .footer-col h4{font-size:1rem;margin-bottom:1rem;color:var(--text)}
        .footer-col p{color:var(--text2);line-height:1.8}
        .footer-col a{display:block;color:var(--text2);padding:0.3rem 0;transition:color 0.2s}
        .footer-col a:hover{color:var(--primary-light)}
        .footer-bottom{text-align:center;padding:1.5rem 0;border-top:1px solid var(--glass-border);color:var(--text2);font-size:0.9rem}
        .fade-up{opacity:0;transform:translateY(40px);transition:all 0.8s cubic-bezier(0.175,0.885,0.32,1.275)}
        .fade-up.visible{opacity:1;transform:translateY(0)}
        .del-btn{display:inline-block;padding:0.4rem 0.8rem;background:rgba(244,63,94,0.1);color:var(--accent2);border:1px solid rgba(244,63,94,0.3);border-radius:6px;text-decoration:none;font-weight:600;font-size:0.85rem}
        .del-btn:hover{background:var(--accent2);color:#fff}
        table{width:100%;border-collapse:collapse;text-align:left}
        td{padding:0.8rem;border-bottom:1px solid var(--glass-border);color:var(--text);vertical-align:top}
        tr:hover td{background:rgba(124,58,237,0.05)}
        thead tr{color:var(--accent);border-bottom:1px solid var(--glass-border)}
        th{padding:0.8rem}
        .intro-container{position:relative;width:100%;height:100vh;display:flex;flex-direction:column;align-items:center;justify-content:center;overflow:hidden;background:radial-gradient(ellipse at center,#0f0f1a 0%,#050508 70%)}
        .particles{position:absolute;top:0;left:0;width:100%;height:100%;pointer-events:none;z-index:0}
        .particle{position:absolute;border-radius:50%;background:var(--primary);opacity:0;animation:float-particle linear infinite}
        @keyframes float-particle{0%{opacity:0;transform:translateY(100vh) scale(0)}10%{opacity:1}90%{opacity:1}100%{opacity:0;transform:translateY(-10vh) scale(1)}}
        .scene{perspective:800px;width:200px;height:200px;z-index:1}
        .cube{width:100%;height:100%;position:relative;transform-style:preserve-3d;animation:cube-spin 4s ease-in-out infinite}
        @keyframes cube-spin{0%{transform:rotateX(0) rotateY(0)}25%{transform:rotateX(90deg) rotateY(90deg)}50%{transform:rotateX(180deg) rotateY(0)}75%{transform:rotateX(270deg) rotateY(-90deg)}100%{transform:rotateX(360deg) rotateY(0)}}
        .cube-face{position:absolute;width:200px;height:200px;border:2px solid var(--primary);background:rgba(124,58,237,0.05);display:flex;align-items:center;justify-content:center;font-size:3rem;font-family:'Orbitron',sans-serif;font-weight:900;color:var(--primary-light)}
        .front{transform:translateZ(100px)}.back{transform:rotateY(180deg) translateZ(100px)}
        .right{transform:rotateY(90deg) translateZ(100px)}.left{transform:rotateY(-90deg) translateZ(100px)}
        .top{transform:rotateX(90deg) translateZ(100px)}.bottom{transform:rotateX(-90deg) translateZ(100px)}
        .front::after{content:'M'}.back::after{content:'E'}
        .right::after{content:'G'}.left::after{content:'A'}
        .top::after{content:'K'}.bottom::after{content:'T'}
        .logo-container{position:relative;z-index:2;margin-top:3rem;text-align:center;opacity:0;animation:fade-in 1s ease forwards 1.5s}
        @keyframes fade-in{to{opacity:1}}
        .logo-text{font-family:'Orbitron',sans-serif;font-size:4rem;font-weight:900;letter-spacing:0.6rem;display:flex;gap:0.3rem;justify-content:center;flex-wrap:wrap}
        .letter{display:inline-block;opacity:0;transform:translateY(-50px) rotateX(90deg);animation:letter-drop 0.6s ease forwards calc(var(--i) * 0.12s + 1.7s);background:linear-gradient(135deg,var(--primary-light),var(--accent));-webkit-background-clip:text;-webkit-text-fill-color:transparent;background-clip:text;filter:drop-shadow(0 0 20px rgba(124,58,237,0.3))}
        @keyframes letter-drop{to{opacity:1;transform:translateY(0) rotateX(0)}}
        .tagline{display:flex;gap:1rem;justify-content:center;margin-top:1rem;font-size:1.3rem;font-weight:300;letter-spacing:0.5rem;text-transform:uppercase;color:var(--text2)}
        .tag-word{opacity:0;transform:translateX(-20px);animation:tag-slide 0.5s ease forwards calc(var(--j) * 0.15s + 2.5s)}
        @keyframes tag-slide{to{opacity:1;transform:translateX(0)}}
        .enter-btn{position:relative;z-index:2;margin-top:3.5rem;padding:1rem 3rem;background:linear-gradient(135deg,var(--primary),var(--primary-dark));color:#fff;font-family:'Orbitron',sans-serif;font-size:1rem;font-weight:700;letter-spacing:0.3rem;text-decoration:none;border:2px solid var(--primary-light);border-radius:50px;cursor:pointer;overflow:hidden;opacity:0;animation:btn-appear 0.8s ease forwards 3.5s;transition:all 0.3s ease;text-transform:uppercase}
        .enter-btn:hover{transform:translateY(-3px) scale(1.05);box-shadow:0 10px 40px rgba(124,58,237,0.5)}
        @keyframes btn-appear{to{opacity:1}}
        .btn-glow{position:absolute;top:-50%;left:-50%;width:200%;height:200%;background:conic-gradient(transparent,rgba(255,255,255,0.1),transparent,rgba(255,255,255,0.1),transparent);animation:glow-spin 3s linear infinite}
        @keyframes glow-spin{to{transform:rotate(360deg)}}
        .btn-text{position:relative;z-index:1}
        body.no-scroll{overflow:hidden}
        .center-page{min-height:100vh;display:flex;flex-direction:column;align-items:center;justify-content:center;text-align:center;padding:2rem}
        .big-title{font-family:'Orbitron',sans-serif;font-size:6rem;background:linear-gradient(135deg,var(--primary-light),var(--accent));-webkit-background-clip:text;-webkit-text-fill-color:transparent}
        @media(max-width:768px){
          .logo-text{font-size:2.2rem;letter-spacing:0.2rem}
          .scene{width:130px;height:130px}
          .cube-face{width:130px;height:130px;font-size:2rem}
          .front{transform:translateZ(65px)}.back{transform:rotateY(180deg) translateZ(65px)}
          .right{transform:rotateY(90deg) translateZ(65px)}.left{transform:rotateY(-90deg) translateZ(65px)}
          .top{transform:rotateX(90deg) translateZ(65px)}.bottom{transform:rotateX(-90deg) translateZ(65px)}
          .hero-title{font-size:2.5rem}
          .product-detail-grid{grid-template-columns:1fr}.detail-image-container{position:static}
          .detail-image-3d{transform:none}.cart-content{grid-template-columns:1fr}
          .cart-summary{position:static}.products-grid{grid-template-columns:repeat(auto-fill,minmax(220px,1fr))}
          .categories-grid{grid-template-columns:repeat(auto-fit,minmax(120px,1fr))}
        }
        """;

    public static String JS = """
        document.addEventListener('DOMContentLoaded', function(){
          var navbar=document.getElementById('navbar');
          if(navbar){window.addEventListener('scroll',function(){navbar.classList.toggle('scrolled',window.scrollY>50);});}
          document.querySelectorAll('.stat-num[data-count]').forEach(function(el){
            var t=parseInt(el.getAttribute('data-count'));if(!t)return;var c=0,inc=t/60;
            var tm=setInterval(function(){c+=inc;if(c>=t){c=t;clearInterval(tm);}
              el.textContent=t>=1000?Math.floor(c).toLocaleString('en-IN')+'+':Math.floor(c);},30);
          });
          document.querySelectorAll('.card-3d-wrapper').forEach(function(card){
            card.addEventListener('mousemove',function(e){var r=card.getBoundingClientRect();
              var x=e.clientX-r.left,y=e.clientY-r.top,cx=r.width/2,cy=r.height/2;
              card.style.transform='translateY(-10px) rotateX('+((y-cy)/15)+'deg) rotateY('+((cx-x)/15)+'deg)';});
            card.addEventListener('mouseleave',function(){card.style.transform='translateY(0) rotateX(0) rotateY(0)';});
          });
          var obs=new IntersectionObserver(function(es){es.forEach(function(en){if(en.isIntersecting)en.target.classList.add('visible');});},{threshold:0.1});
          document.querySelectorAll('.cat-card,.product-card,.deal-card,.section-header').forEach(function(el){el.classList.add('fade-up');obs.observe(el);});
        });
        function sortProducts(c){var g=document.getElementById('productsGrid');if(!g)return;
          var cs=Array.from(g.querySelectorAll('.product-card'));
          cs.sort(function(a,b){var A=a.dataset.price-0,B=b.dataset.price-0;
            switch(c){
              case 'price-low':return A-B;
              case 'price-high':return B-A;
              case 'rating':return b.dataset.rating-a.dataset.rating;
              case 'discount':return b.dataset.discount-a.dataset.discount;
              default:return 0;}});
          cs.forEach(function(cd){g.appendChild(cd);});
        }
        """;

    public static String INTRO_JS = """
        document.addEventListener('DOMContentLoaded',function(){
          var pc=document.getElementById('particles');if(!pc)return;
          var cols=['#7c3aed','#06b6d4','#f43f5e','#a78bfa'];
          for(var i=0;i<36;i++){var p=document.createElement('div');p.className='particle';
            var s=Math.random()*6+2;p.style.width=s+'px';p.style.height=s+'px';
            p.style.left=Math.random()*100+'%';p.style.background=cols[Math.floor(Math.random()*cols.length)];
            p.style.animationDuration=(Math.random()*6+4)+'s';p.style.animationDelay=Math.random()*5+'s';pc.appendChild(p);}
          document.addEventListener('mousemove',function(e){
            var cube=document.getElementById('cube');if(!cube)return;
            var x=(e.clientX/window.innerWidth-0.5)*20,y=(e.clientY/window.innerHeight-0.5)*20;
            cube.style.transform='rotateX('+(-y)+'deg) rotateY('+x+'deg)';cube.style.animation='none';});
        });
        """;

    private static String head(String title) {
        return "<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'>"
            + "<meta name='viewport' content='width=device-width, initial-scale=1.0'>"
            + "<title>" + title + "</title>"
            + "<link href='https://fonts.googleapis.com/css2?family=Orbitron:wght@400;700;900&family=Rajdhani:wght@300;400;500;600;700&display=swap' rel='stylesheet'>"
            + "<style>" + CSS + "</style></head><body class='" + (title.equals("MEGA-KART - Welcome") ? "no-scroll" : "") + "'>";
    }

    private static String nav(int cartCount) { return nav(cartCount, null); }

    private static String nav(int cartCount, String username) {
        String auth;
        if (username == null || username.isEmpty()) {
            auth = "<a href='/login' class='nav-link'>Login</a><a href='/register' class='nav-link'>Register</a>";
        } else {
            auth = "<span class='nav-link user-chip'>👤 " + esc(username) + "</span><a href='/logout' class='nav-link'>Logout</a>";
        }
        return "<nav class='navbar' id='navbar'><div class='nav-inner'>"
            + "<a href='/' class='nav-logo'><span class='logo-n'>M</span>EGA<span class='logo-3d'>-KART</span></a>"
            + "<div class='nav-search'><form action='/shop' method='get' class='search-form'>"
            + "<input type='text' name='search' placeholder='Search products...' class='search-input' autocomplete='off'>"
            + "<button type='submit' class='search-btn'><svg width='20' height='20' viewBox='0 0 24 24' fill='none' stroke='currentColor' stroke-width='2'><circle cx='11' cy='11' r='8'/><path d='m21 21-4.35-4.35'/></svg></button>"
            + "</form></div><div class='nav-actions'><a href='/shop' class='nav-link'>Shop</a>"
            + auth
            + "<a href='/admin' class='nav-link'>Admin</a>"
            + "<div class='nav-cart'><a href='/cart' class='cart-link'>"
            + "<svg width='24' height='24' viewBox='0 0 24 24' fill='none' stroke='currentColor' stroke-width='2'><circle cx='9' cy='21' r='1'/><circle cx='20' cy='21' r='1'/><path d='M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6'/></svg>"
            + "<span class='cart-badge'>" + cartCount + "</span></a></div></div></nav>";
    }

    private static String authShell(String title, String heading, String formHtml) {
        return head(title) + nav(0, null)
            + "<div class='center-page'><div style='background:var(--bg2);border:1px solid var(--glass-border);border-radius:20px;padding:2.5rem;width:100%;max-width:420px;box-shadow:0 20px 60px rgba(0,0,0,0.4)'>"
            + "<h1 style='font-family:Orbitron,sans-serif;text-align:center;margin-bottom:1.5rem'>" + heading + "</h1>"
            + formHtml + "</div></div></body></html>";
    }

    public static String login(String error) {
        String err = error == null ? "" : "<p style='color:#f43f5e;font-weight:700;margin-bottom:1rem'>" + esc(error) + "</p>";
        return authShell("Login - MEGA-KART", "Login",
            err + "<form method='post' action='/login' style='display:flex;flex-direction:column;gap:1rem'>"
            + "<input type='text' name='username' placeholder='Username' required style='width:100%;padding:0.9rem;background:var(--glass);border:1px solid var(--glass-border);border-radius:8px;color:var(--text);font-family:Rajdhani;font-size:1rem'>"
            + "<input type='password' name='password' placeholder='Password' required style='width:100%;padding:0.9rem;background:var(--glass);border:1px solid var(--glass-border);border-radius:8px;color:var(--text);font-family:Rajdhani;font-size:1rem'>"
            + "<button type='submit' class='checkout-btn'>Login</button></form>"
            + "<p style='text-align:center;margin-top:1rem;color:var(--text2)'>New here? <a href='/register' style='color:var(--primary-light);font-weight:700'>Create account</a></p>");
    }

    public static String register(String error) {
        String err = error == null ? "" : "<p style='color:#f43f5e;font-weight:700;margin-bottom:1rem'>" + esc(error) + "</p>";
        return authShell("Register - MEGA-KART", "Create Account",
            err + "<form method='post' action='/register' style='display:flex;flex-direction:column;gap:1rem'>"
            + "<input type='text' name='username' placeholder='Username' required style='width:100%;padding:0.9rem;background:var(--glass);border:1px solid var(--glass-border);border-radius:8px;color:var(--text);font-family:Rajdhani;font-size:1rem'>"
            + "<input type='email' name='email' placeholder='Email' required style='width:100%;padding:0.9rem;background:var(--glass);border:1px solid var(--glass-border);border-radius:8px;color:var(--text);font-family:Rajdhani;font-size:1rem'>"
            + "<input type='password' name='password' placeholder='Password' required style='width:100%;padding:0.9rem;background:var(--glass);border:1px solid var(--glass-border);border-radius:8px;color:var(--text);font-family:Rajdhani;font-size:1rem'>"
            + "<button type='submit' class='checkout-btn'>Register</button></form>"
            + "<p style='text-align:center;margin-top:1rem;color:var(--text2)'>Already have an account? <a href='/login' style='color:var(--primary-light);font-weight:700'>Login</a></p>");
    }

    public static String forbidden() {
        return head("Forbidden - MEGA-KART") + nav(0, null)
            + "<div class='center-page'><h1 class='big-title' style='font-size:4rem'>403</h1>"
            + "<p style='font-size:1.2rem;color:var(--text2);margin:1rem 0 2rem'>Admin access only. Please login as an admin account.</p>"
            + "<div style='display:flex;gap:1rem'><a href='/admin/login' class='btn-primary'>Admin Login</a><a href='/shop' class='btn-continue'>Shop</a></div></div></body></html>";
    }

    public static String adminLogin(String error) {
        String err = error == null ? "" : "<p style='color:#f43f5e;font-weight:700;margin-bottom:1rem'>" + esc(error) + "</p>";
        return authShell("Admin Login - MEGA-KART", "🔐 Admin Login",
            err + "<form method='post' action='/admin/login' style='display:flex;flex-direction:column;gap:1rem'>"
            + "<input type='text' name='username' placeholder='Admin Username' required style='width:100%;padding:0.9rem;background:var(--glass);border:1px solid var(--glass-border);border-radius:8px;color:var(--text);font-family:Rajdhani;font-size:1rem'>"
            + "<input type='password' name='password' placeholder='Admin Password' required style='width:100%;padding:0.9rem;background:var(--glass);border:1px solid var(--glass-border);border-radius:8px;color:var(--text);font-family:Rajdhani;font-size:1rem'>"
            + "<button type='submit' class='checkout-btn'>Login to Dashboard</button></form>"
            + "<p style='font-size:0.85rem;color:var(--text2);text-align:center;margin-top:1rem'>Staff / Owners only. <a href='/shop' style='color:var(--primary-light)'>&larr; Back to shop</a></p>");
    }

    private static String footer() {
        return "<footer class='footer'><div class='footer-grid'>"
            + "<div class='footer-col'><h3><span class='logo-n'>M</span>EGA<span class='logo-3d'>-KART</span></h3><p>Experience the future of shopping with our immersive 3D platform.</p></div>"
            + "<div class='footer-col'><h4>Quick Links</h4><a href='/shop'>All Products</a><a href='/cart'>Cart</a><a href='/admin'>Admin - Bookings</a></div>"
            + "<div class='footer-col'><h4>Categories</h4><a href='/shop?category=electronics'>Electronics</a><a href='/shop?category=fashion'>Fashion</a><a href='/shop?category=home'>Home & Living</a><a href='/shop?category=sports'>Sports</a></div>"
            + "<div class='footer-col'><h4>Contact</h4><p>support@megakart.in</p><p>1800-123-4567 (Toll Free)</p></div>"
            + "</div><div class='footer-bottom'><p>&copy; 2026 MEGA-KART. CODSOFT Internship Project. All rights reserved.</p></div></footer>";
    }

    // ================= INTRO PAGE =================
    public static String intro() {
        StringBuilder letters = new StringBuilder();
        String word = "MEGA-KART";
        for (int i = 0; i < word.length(); i++) {
            letters.append("<span class='letter' style='--i:").append(i).append("'>").append(word.charAt(i)).append("</span>");
        }
        return head("MEGA-KART - Welcome")
            + "<div class='intro-container'><div class='particles' id='particles'></div>"
            + "<div style='position:absolute;top:1.5rem;right:2rem;z-index:3;display:flex;gap:1rem'>"
            + "<a href='/login' style='color:var(--text2);text-decoration:none;font-weight:600;padding:0.5rem 1.2rem;border-radius:50px;border:1px solid var(--glass-border);transition:all 0.3s'>Login</a>"
            + "<a href='/register' style='color:#fff;text-decoration:none;font-weight:700;padding:0.5rem 1.2rem;border-radius:50px;background:linear-gradient(135deg,var(--primary),var(--primary-dark));border:1px solid var(--primary-light);transition:all 0.3s'>Register</a></div>"
            + "<div class='scene'><div class='cube' id='cube'>"
            + "<div class='cube-face front'></div><div class='cube-face back'></div><div class='cube-face right'></div>"
            + "<div class='cube-face left'></div><div class='cube-face top'></div><div class='cube-face bottom'></div>"
            + "</div></div><div class='logo-container'><h1 class='logo-text'>" + letters + "</h1>"
            + "<div class='tagline'><span class='tag-word' style='--j:0'>India's</span><span class='tag-word' style='--j:1'>#1</span><span class='tag-word' style='--j:2'>3D</span><span class='tag-word' style='--j:3'>Shopping</span></div></div>"
            + "<a href='/shop' class='enter-btn'><span class='btn-text'>ENTER MEGA-KART</span><div class='btn-glow'></div></a></div>"
            + "<script>" + INTRO_JS + "</script></body></html>";
    }

    // ================= SHOP PAGE =================
    public static String shop(String title, List<Product> products, String selected, int cartCount, List<Product> deals, String username) {
        StringBuilder cards = new StringBuilder();
        for (Product p : products) cards.append(productCard(p));
        StringBuilder cats = new StringBuilder();
        String[][] cc = {{"all","All Products","🛍️"},{"electronics","Electronics","💻"},{"fashion","Fashion","👗"},{"home","Home & Living","🏠"},{"sports","Sports & Fitness","⚽"},{"books","Books","📚"},{"beauty","Beauty","✨"}};
        for (String[] c : cc) {
            boolean active = (selected == null || selected.isEmpty()) ? c[0].equals("all") : c[0].equals(selected);
            String href = c[0].equals("all") ? "/shop" : "/shop?category=" + c[0];
            cats.append("<a href='").append(href).append("' class='cat-card").append(active ? " active" : "").append("'><div class='cat-icon'>").append(c[2]).append("</div><span>").append(c[1]).append("</span></a>");
        }
        return head("MEGA-KART - Shop") + nav(cartCount, username)
            + "<section class='hero-section'><div class='hero-bg'><div class='hero-orb orb-1'></div><div class='hero-orb orb-2'></div><div class='hero-orb orb-3'></div></div>"
            + "<div class='hero-content'><h1 class='hero-title'><span class='hero-line'>Shop</span><span class='hero-line gradient-text'>Epic</span><span class='hero-line'>Deals</span></h1>"
            + "<p class='hero-sub'>Explore our curated collection with immersive 3D shopping experience</p>"
            + "<div class='hero-stats'><div class='stat-item'><span class='stat-num' data-count='31'>0</span><span class='stat-label'>Products</span></div>"
            + "<div class='stat-item'><span class='stat-num' data-count='6'>0</span><span class='stat-label'>Categories</span></div>"
            + "<div class='stat-item'><span class='stat-num' data-count='50000'>0</span><span class='stat-label'>Happy Users</span></div></div></div></section>"
            + "<section class='categories-section'><div class='section-header'><h2 class='section-title'>Browse Categories</h2><div class='title-underline'></div></div>"
            + "<div class='categories-grid'>" + cats + "</div></section>"
            + "<section class='products-section'><div class='section-header'><h2 class='section-title'>" + title + "</h2><div class='title-underline'></div>"
            + "<div class='sort-controls'><select class='sort-select' onchange='sortProducts(this.value)'><option value='default'>Sort by: Featured</option><option value='price-low'>Price: Low to High</option><option value='price-high'>Price: High to Low</option><option value='rating'>Highest Rated</option><option value='discount'>Biggest Discount</option></select></div></div>"
            + "<div class='products-grid' id='productsGrid'>" + cards + "</div></section>"
            + dealsSection(deals)
            + footer()
            + "<script>" + JS + "</script></body></html>";
    }

    private static String dealsSection(List<Product> deals) {
        if (deals == null || deals.isEmpty()) return "";
        StringBuilder sb = new StringBuilder("<section class='deals-section'><div class='section-header'><h2 class='section-title'>Hot Deals</h2><div class='title-underline'></div></div><div class='deals-carousel'>");
        for (Product p : deals) {
            sb.append("<div class='deal-card'><div class='deal-image'><img src='").append(p.getImage()).append("' alt='").append(esc(p.getName())).append("' loading='lazy'>")
              .append("<div class='deal-badge'>-").append((long)p.getDiscount()).append("% OFF</div></div>")
              .append("<div class='deal-info'><h3>").append(esc(p.getName())).append("</h3>")
              .append("<div class='deal-prices'><span class='deal-now'>").append(inr(p.getPrice())).append("</span>")
              .append("<span class='deal-was'>").append(inr(p.getOriginalPrice())).append("</span></div>")
              .append("<a href='/cart/add/").append(p.getId()).append("?from=/shop' class='deal-btn'>Grab Deal</a></div></div>");
        }
        sb.append("</div></section>");
        return sb.toString();
    }

    private static String productCard(Product p) {
        return "<div class='product-card' data-id='" + p.getId() + "' data-price='" + p.getPrice() + "' data-rating='" + p.getRating() + "' data-discount='" + p.getDiscount() + "'>"
            + "<div class='card-3d-wrapper'><a href='/product/" + p.getId() + "' class='card-link'>"
            + "<div class='card-image'><img src='" + p.getImage() + "' alt='" + esc(p.getName()) + "' loading='lazy'>"
            + (p.getDiscount() > 0 ? "<div class='card-badge'>-" + (long)p.getDiscount() + "%</div>" : "")
            + "<div class='card-overlay'><span class='quick-view'>Quick View</span></div></div>"
            + "<div class='card-body'><span class='card-brand'>" + esc(p.getBrand()) + "</span>"
            + "<h3 class='card-title'>" + esc(p.getName()) + "</h3>"
            + "<div class='card-rating'><div class='stars'>" + stars(p.getRating()) + "</div><span class='review-count'>(" + p.getReviews() + ")</span></div>"
            + "<div class='card-price'><span class='current-price'>" + inr(p.getPrice()) + "</span>"
            + (p.getOriginalPrice() > p.getPrice() ? "<span class='original-price'>" + inr(p.getOriginalPrice()) + "</span>" : "")
            + "</div></div></a><div class='card-actions'>"
            + "<a href='/cart/add/" + p.getId() + "?from=/shop' class='add-to-cart-btn'><svg width='20' height='20' viewBox='0 0 24 24' fill='none' stroke='currentColor' stroke-width='2'><circle cx='9' cy='21' r='1'/><circle cx='20' cy='21' r='1'/><path d='M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6'/></svg><span>Add to Cart</span></a>"
            + "</div></div></div>";
    }

    // ================= PRODUCT PAGE =================
    public static String product(Product p, int cartCount, String username) {
        StringBuilder specs = new StringBuilder();
        if (p.getSpecs() != null && !p.getSpecs().isEmpty()) {
            for (String[] row : p.getSpecs()) {
                specs.append("<tr><td class='spec-name'>").append(esc(row[0])).append("</td><td>").append(esc(row[1])).append("</td></tr>");
            }
        } else {
            specs.append("<tr><td class='spec-name'>Brand</td><td>").append(esc(p.getBrand())).append("</td></tr>")
                 .append("<tr><td class='spec-name'>Category</td><td>").append(cap(p.getCategory())).append("</td></tr>");
        }
        return head(esc(p.getName()) + " - MEGA-KART") + nav(cartCount, username)
            + "<div class='breadcrumb'><a href='/shop'>Home</a> / <span>" + cap(p.getCategory()) + "</span> / <span>" + esc(p.getName()) + "</span></div>"
            + "<section class='product-detail-section'><div class='product-detail-grid'>"
            + "<div class='detail-image-container'><div class='detail-image-3d'><img src='" + p.getImage() + "' alt='" + esc(p.getName()) + "' class='detail-img'><div class='image-glow'></div></div></div>"
            + "<div class='detail-info'><span class='detail-brand'>" + esc(p.getBrand()) + "</span>"
            + "<h1 class='detail-name'>" + esc(p.getName()) + "</h1>"
            + "<div class='detail-rating'><div class='stars'>" + stars(p.getRating()) + "</div><span class='rating-num'>" + p.getRating() + "</span><span class='review-count'>(" + p.getReviews() + " reviews)</span></div>"
            + "<div class='detail-price-block'><span class='detail-price'>" + inr(p.getPrice()) + "</span>"
            + (p.getOriginalPrice() > p.getPrice() ? "<span class='detail-original'>" + inr(p.getOriginalPrice()) + "</span>" : "")
            + (p.getDiscount() > 0 ? "<span class='detail-discount'>" + (long)p.getDiscount() + "% OFF</span>" : "")
            + "</div><p class='detail-desc'>" + esc(p.getDescription()) + "</p>"
            + "<div class='detail-stock " + (p.isInStock() ? "in-stock" : "out-stock") + "'><span class='stock-dot'></span><span>" + (p.isInStock() ? "In Stock - Ready to Ship" : "Out of Stock") + "</span></div>"
            + "<div class='detail-actions'><a href='/cart/add/" + p.getId() + "?from=/product/" + p.getId() + "' class='btn-add-cart-large'>"
            + "<svg width='24' height='24' viewBox='0 0 24 24' fill='none' stroke='currentColor' stroke-width='2'><circle cx='9' cy='21' r='1'/><circle cx='20' cy='21' r='1'/><path d='M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6'/></svg> Add to Cart</a>"
            + "<a href='/shop' class='btn-continue'>Continue Shopping</a></div>"
            + "<div class='detail-features'><div class='feature'><span>&#128666;</span><span>Free Shipping</span></div><div class='feature'><span>&#128274;</span><span>Secure Payment</span></div><div class='feature'><span>&#8617;&#65039;</span><span>30 Day Returns</span></div><div class='feature'><span>&#128737;</span><span>2 Year Warranty</span></div></div>"
            + "</div></div></section>"
            + "<section class='detail-sections'><div class='detail-tabs'><button class='detail-tab active' onclick='showTab(this,\"desc\")'>Description</button><button class='detail-tab' onclick='showTab(this,\"specs\")'>Specifications</button><button class='detail-tab' onclick='showTab(this,\"warranty\")'>Warranty & Returns</button></div>"
            + "<div class='detail-tab-content' id='tab-desc'>"
            + "<h2 class='detail-section-title'>About this item</h2>"
            + "<p class='long-desc'>" + esc(p.getLongDescription() == null || p.getLongDescription().isEmpty() ? p.getDescription() : p.getLongDescription()) + "</p>"
            + "</div>"
            + "<div class='detail-tab-content' id='tab-specs' style='display:none'>"
            + "<h2 class='detail-section-title'>Product Specifications</h2>"
            + "<table class='spec-table'><tbody>" + specs + "</tbody></table>"
            + "</div>"
            + "<div class='detail-tab-content' id='tab-warranty' style='display:none'>"
            + "<h2 class='detail-section-title'>Warranty & Returns</h2>"
            + "<ul class='warranty-list'><li>1 year manufacturer warranty on the product</li><li>7-day no-questions-asked replacement policy</li><li>Free shipping across India</li><li>Secure payments with easy EMI options available at checkout</li><li>Dedicated customer support at 1800-123-4567</li></ul>"
            + "</div></section>"
            + "<script>function showTab(b,id){document.querySelectorAll('.detail-tab').forEach(function(t){t.classList.remove('active')});b.classList.add('active');['desc','specs','warranty'].forEach(function(k){document.getElementById('tab-'+k).style.display=(k===id)?'block':'none';});}</script>"
            + "<script>" + JS + "</script></body></html>";
    }

    // ================= CART PAGE =================
    public static String cart(Cart cart, int cartCount, String username) {
        StringBuilder items = new StringBuilder();
        for (CartItem it : cart.getItems()) {
            Product p = it.getProduct();
            String decBtn = it.getQuantity() <= 1 ? "🗑" : "−";
            items.append("<div class='cart-item'><div class='item-image'><img src='").append(p.getImage()).append("' alt='").append(esc(p.getName())).append("'></div>")
                .append("<div class='item-details'><a href='/product/").append(p.getId()).append("' class='item-name'>").append(esc(p.getName())).append("</a>")
                .append("<span class='item-brand'>").append(esc(p.getBrand())).append("</span>")
                .append("<span class='item-price-unit'>").append(inr(p.getPrice())).append(" each</span></div>")
                .append("<div class='item-quantity'><div class='qty-form'>")
                .append("<a href='/cart/update?productId=").append(p.getId()).append("&quantity=").append(decBtn.equals("🗑") ? 0 : it.getQuantity() - 1).append("' class='qty-btn'>").append(decBtn).append("</a>")
                .append("<span class='qty-num'>").append(it.getQuantity()).append("</span>")
                .append("<a href='/cart/update?productId=").append(p.getId()).append("&quantity=").append(it.getQuantity() + 1).append("' class='qty-btn'>+</a></div></div>")
                .append("<div class='item-total'>").append(inr(it.getTotalPrice())).append("</div>")
                .append("<a href='/cart/remove/").append(p.getId()).append("' class='remove-btn'><svg width='18' height='18' viewBox='0 0 24 24' fill='none' stroke='currentColor' stroke-width='2'><path d='M3 6h18'/><path d='M19 6v14c0 1-1 2-2 2H7c-1 0-2-1-2-2V6'/><path d='M8 6V4c0-1 1-2 2-2h4c1 0 2 1 2 2v2'/></svg></a></div>");
        }
        String body;
        if (cart.getItems().isEmpty()) {
            body = "<div class='empty-cart'><div class='empty-cart-icon'><svg width='80' height='80' viewBox='0 0 24 24' fill='none' stroke='currentColor' stroke-width='1'><circle cx='9' cy='21' r='1'/><circle cx='20' cy='21' r='1'/><path d='M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6'/></svg></div><h2>Your cart is empty</h2><p>Looks like you haven't added anything yet.</p><a href='/shop' class='btn-primary'>Start Shopping</a></div>";
        } else {
            body = "<div class='cart-content'><div class='cart-items'>" + items + "</div>"
                + "<div class='cart-summary'><h3>Order Summary</h3>"
                + "<div class='summary-row'><span>Subtotal</span><span>" + inr(cart.getTotal()) + "</span></div>"
                + "<div class='summary-row'><span>Shipping</span><span class='free-shipping'>FREE</span></div>"
                + "<div class='summary-row'><span>GST (8%)</span><span>" + inr(cart.getTotal() * 0.08) + "</span></div>"
                + "<div class='summary-divider'></div><div class='summary-row total'><span>Total</span><span>" + inr(cart.getTotal() * 1.08) + "</span></div>"
                + "<a href='/checkout' class='checkout-btn' style='display:block;text-align:center'>Proceed to Checkout</a>"
                + "<a href='/shop' class='continue-link'>&larr; Continue Shopping</a>"
                + "<a href='/cart/clear' class='btn-primary' style='display:block;text-align:center;margin-top:1rem;background:transparent;border:1px solid rgba(244,63,94,0.4);color:var(--accent2)'>Clear Cart</a></div></div>";
        }
        return head("Cart - MEGA-KART") + nav(cartCount, username)
            + "<section class='cart-section'><div class='cart-header'><h1 class='cart-title'>Shopping Cart</h1><span class='cart-count'>" + cartCount + " items</span></div>"
            + body + "</section>" + footer()
            + "<script>" + JS + "</script></body></html>";
    }

    // ================= CHECKOUT PAGE =================
    public static String checkout(Cart cart, int cartCount, String username) {
        return head("Checkout - MEGA-KART") + nav(cartCount, username)
            + "<section class='cart-section'><div class='cart-header'><h1 class='cart-title'>Checkout</h1><a href='/cart' class='continue-link'>&larr; Back to Cart</a></div>"
            + "<div style='display:grid;grid-template-columns:1fr 380px;gap:2rem;align-items:start'>"
            + "<form action='/checkout' method='post' style='background:var(--bg2);border:1px solid var(--glass-border);border-radius:16px;padding:2rem'>"
            + "<h3 style='font-family:Orbitron,sans-serif;margin-bottom:1.5rem'>Shipping Details</h3>"
            + "<div style='display:flex;flex-direction:column;gap:1rem'>"
            + "<div><label style='display:block;margin-bottom:0.3rem;color:var(--text2);font-weight:600'>Full Name</label><input type='text' name='name' required style='width:100%;padding:0.8rem;background:var(--glass);border:1px solid var(--glass-border);border-radius:8px;color:var(--text);font-family:Rajdhani;font-size:1rem'></div>"
            + "<div><label style='display:block;margin-bottom:0.3rem;color:var(--text2);font-weight:600'>Email</label><input type='email' name='email' required style='width:100%;padding:0.8rem;background:var(--glass);border:1px solid var(--glass-border);border-radius:8px;color:var(--text);font-family:Rajdhani;font-size:1rem'></div>"
            + "<div><label style='display:block;margin-bottom:0.3rem;color:var(--text2);font-weight:600'>Phone</label><input type='tel' name='phone' required style='width:100%;padding:0.8rem;background:var(--glass);border:1px solid var(--glass-border);border-radius:8px;color:var(--text);font-family:Rajdhani;font-size:1rem'></div>"
            + "<div><label style='display:block;margin-bottom:0.3rem;color:var(--text2);font-weight:600'>Delivery Address</label><textarea name='address' required rows='3' style='width:100%;padding:0.8rem;background:var(--glass);border:1px solid var(--glass-border);border-radius:8px;color:var(--text);font-family:Rajdhani;font-size:1rem;resize:vertical'></textarea></div>"
            + "<button type='submit' class='checkout-btn' style='margin-top:1rem'>Place Order</button></div></form>"
            + "<div class='cart-summary' style='position:static'><h3>Order Summary</h3>"
            + "<div class='summary-row'><span>Subtotal</span><span>" + inr(cart.getTotal()) + "</span></div>"
            + "<div class='summary-row'><span>Shipping</span><span class='free-shipping'>FREE</span></div>"
            + "<div class='summary-row'><span>GST (8%)</span><span>" + inr(cart.getTotal() * 0.08) + "</span></div>"
            + "<div class='summary-divider'></div><div class='summary-row total'><span>Total</span><span>" + inr(cart.getTotal() * 1.08) + "</span></div></div>"
            + "</div></section><script>" + JS + "</script></body></html>";
    }

    // ================= SUCCESS PAGE =================
    public static String success(String orderId, String username) {
        return head("Order Confirmed - MEGA-KART") + nav(0, username)
            + "<div class='center-page'><div style='width:100px;height:100px;border-radius:50%;background:rgba(34,197,94,0.15);display:flex;align-items:center;justify-content:center;font-size:3rem;margin-bottom:1.5rem;animation:float 3s ease-in-out infinite'>&#9989;</div>"
            + "<h1 style='font-family:Orbitron,sans-serif;font-size:2rem;margin-bottom:0.5rem'>Order Placed Successfully!</h1>"
            + "<p style='color:var(--text2);font-size:1.1rem;margin-bottom:0.5rem'>Thank you for shopping at MEGA-KART.</p>"
            + "<p style='color:var(--primary-light);font-weight:700;font-size:1.2rem;margin-bottom:2rem'>Order ID: " + esc(orderId) + "</p>"
            + "<div style='display:flex;gap:1rem'><a href='/shop' class='btn-primary'>Continue Shopping</a><a href='/admin' class='btn-continue'>View Bookings (Admin)</a></div></div>"
            + "</body></html>";
    }

    // ================= ADMIN PAGE =================
    public static String admin(List<Booking> orders, String inrRevenue, String username) {
        StringBuilder rows = new StringBuilder();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd MMM yyyy HH:mm");
        if (orders.isEmpty()) {
            rows.append("<tr><td colspan='8' style='text-align:center;padding:2rem;color:#94a3b8'>No bookings yet. Place an order on the shop first.</td></tr>");
        } else {
            for (Booking b : orders) {
                StringBuilder it = new StringBuilder();
                for (CartItem ci : b.getItems()) {
                    it.append("<li>").append(esc(ci.getProduct().getName())).append(" x").append(ci.getQuantity()).append(" (").append(inr(ci.getProduct().getPrice())).append(")</li>");
                }
                rows.append("<tr><td>").append(esc(b.getOrderId())).append("</td>")
                    .append("<td>").append(sdf.format(new Date(b.getTimestamp()))).append("</td>")
                    .append("<td>").append(esc(b.getCustomerName())).append("</td>")
                    .append("<td>").append(esc(b.getCustomerEmail())).append("<br><small>").append(esc(b.getPhone())).append(" | ").append(esc(b.getAddress())).append("</small></td>")
                    .append("<td>").append(b.getItems().size()).append(" item(s)</td>")
                    .append("<td><ul style='margin:0;padding-left:1rem'>").append(it).append("</ul></td>")
                    .append("<td>").append(inr(b.getTotal())).append("</td>")
                    .append("<td><a href='/admin/remove/").append(java.net.URLEncoder.encode(b.getOrderId(), java.nio.charset.StandardCharsets.UTF_8)).append("' class='del-btn'>Delete</a></td></tr>");
            }
        }
        return head("Admin - Bookings | MEGA-KART") + nav(0, username)
            + "<section class='cart-section' style='max-width:1300px'><div class='cart-header'>"
            + "<div><h1 class='cart-title'>Backend Bookings</h1><a href='/admin/logout' class='del-btn' style='margin-top:0.5rem'>Logout Admin</a></div>"
            + "<div style='display:flex;gap:2rem;align-items:center'><div class='stat-item'><span class='stat-num'>" + orders.size() + "</span><span class='stat-label'>Orders</span></div>"
            + "<div class='stat-item'><span class='stat-num' style='font-size:1.3rem'>" + inrRevenue + "</span><span class='stat-label'>Revenue</span></div></div></div>"
            + "<div style='overflow-x:auto;background:var(--bg2);border:1px solid var(--glass-border);border-radius:16px;padding:1.5rem'>"
            + "<table><thead><tr><th>Order ID</th><th>Date</th><th>Customer</th><th>Contact</th><th>Items</th><th>Details</th><th>Total</th><th>Action</th></tr></thead><tbody>"
            + rows + "</tbody></table></div></section>"
            + "<script>" + JS + "</script></body></html>";
    }

    // ================= 404 =================
    public static String notFound() {
        return head("404 - MEGA-KART") + nav(0)
            + "<div class='center-page'><h1 class='big-title'>404</h1><p style='font-size:1.3rem;color:var(--text2);margin:1rem 0 2rem'>Page not found in this dimension</p><a href='/shop' class='btn-primary'>Go to Shop</a></div></body></html>";
    }

    // ================= HELPERS =================
    private static String stars(double rating) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            sb.append("<span class='star").append(i <= rating ? " filled" : "").append("'>★</span>");
        }
        return sb.toString();
    }

    static String cap(String s) {
        if (s == null || s.isEmpty()) return "";
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    public static String inr(double amount) {
        return "₹" + groupIndian(Math.round(amount));
    }

    private static String groupIndian(long value) {
        boolean neg = value < 0;
        String x = Long.toString(Math.abs(value));
        if (x.length() <= 3) return (neg ? "-" : "") + x;
        StringBuilder sb = new StringBuilder(x);
        int i = sb.length() - 3;
        sb.insert(i, ',');
        i -= 2;
        while (i > 0) { sb.insert(i, ','); i -= 2; }
        return (neg ? "-" : "") + sb.toString();
    }

    static String esc(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
                .replace("\"", "&quot;").replace("'", "&#39;");
    }
}
