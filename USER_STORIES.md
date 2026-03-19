# hck-1

Here are three challenging user stories for the Myntra platform, designed for your Sprint 1 implementation. These are written to test the limits of your automation architecture, requiring robust handling of asynchronous events, complex DOM structures, and dynamic data validation. 

True to your request, these contain zero implementation hints. 

### **User Story 1: Dynamic Multi-Parameter Filtering and Lazy Load Validation**
**As a** shopper,
**I want to** apply multiple overlapping search filters,
**So that** I only see products that strictly match my complex criteria.

**Acceptance Criteria:**
1. Navigate to Myntra and search for a broad category (e.g., "Sneakers").
2. Apply the following filters dynamically in sequence:
   * **Brand:** Select at least three distinct brands.
   * **Price:** Adjust the price slider/checkboxes to a custom range (e.g., Rs. 2000 to Rs. 5000).
   * **Discount:** Select a minimum discount percentage (e.g., "40% and above").
3. Scroll through the product grid to trigger at least two lazy-loading events.
4. Extract the data for the first 100 loaded products.
5. **Validation:** Assert that *every single product* among the 100 strictly adheres to the selected brands, falls within the exact price range, and reflects the correct minimum discount percentage. 

---

### **User Story 2: Deep DOM Navigation and State Management in Cart**
**As a** registered user,
**I want to** manage multiple items with varying configurations in my shopping bag,
**So that** I can accurately review my final checkout price breakdown.

**Acceptance Criteria:**
1. Navigate to three distinct product pages (e.g., a shirt, a pair of jeans, and a watch).
2. For the apparel items, select specific, non-default sizes. 
3. Add all three items to the bag.
4. Navigate to the Bag.
5. Change the quantity of the lowest-priced item to '3'.
6. Move the highest-priced item to the Wishlist.
7. **Validation:** Dynamically calculate and assert the "Price Details" section. Your script must independently verify the math for:
   * Total MRP
   * Discount on MRP
   * Coupon Discount (if any applied automatically)
   * Platform Fee
   * Shipping Fee
   * Total Amount

---

### **User Story 3: Interstitial Overlay and Nested Hover Navigation**
**As a** casual browser,
**I want to** navigate through nested mega-menus and interact with specific product overlays,
**So that** I can view similar items without navigating away from my current search grid.

**Acceptance Criteria:**
1. From the homepage, use mouse interactions to navigate the main navigation bar: Hover over "Women" -> Hover over "Beauty & Personal Care" -> Click on "Lipstick".
2. On the results page, hover over the 5th product in the grid to reveal the hidden overlay menu.
3. Click the "View Similar" icon on that specific product's overlay.
4. A dynamic side-panel or modal containing similar products will appear. 
5. **Validation:** Verify that the "Similar Products" modal is active and strictly in focus. Count the number of items in the similar products tray, and assert that the primary brand name of the original 5th product appears in at least 50% of the suggested similar items. 
6. Close the modal and return to the original grid state.
