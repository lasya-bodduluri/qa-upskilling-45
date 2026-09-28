import { test, expect } from '@playwright/test';

test('Day 18 - Window and Tab Handling', async ({ page }) => {

    // ==========================================
    // 1. OPEN PARENT PAGE
    // ==========================================

    await page.goto('https://the-internet.herokuapp.com/windows');

    const parentPage = page;

    // ==========================================
    // 2. WAIT FOR NEW TAB
    // ==========================================

    const newPagePromise = page.waitForEvent('popup');

    // ==========================================
    // 3. CLICK LINK
    // ==========================================

    await page.getByRole('link', { name: 'Click Here' }).click();

    // ==========================================
    // 4. GET CHILD PAGE
    // ==========================================

    const childPage = await newPagePromise;

    // ==========================================
    // 5. VERIFY CHILD PAGE
    // ==========================================

    await expect(childPage.getByRole('heading')).toHaveText('New Window');

    // ==========================================
    // 6. CLOSE CHILD PAGE
    // ==========================================

    await childPage.close();

    // ==========================================
    // 7. VERIFY PARENT PAGE
    // ==========================================

    await expect(parentPage.getByRole('heading')).toHaveText('Opening a new window');

});