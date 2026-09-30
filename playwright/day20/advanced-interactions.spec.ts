import { test, expect } from '@playwright/test';

test('Day 20 - Advanced Interactions', async ({ page }) => {

    // ==========================================
    // 1. SHADOW DOM
    // ==========================================

    await page.goto('https://the-internet.herokuapp.com/shadowdom');

    const shadowText = page.locator('my-paragraph').locator('p').first()

    await expect(shadowText).toBeVisible();

    await expect(shadowText).not.toHaveText('');

    await page.screenshot({path: 'screenshots/playwright/01-shadow-dom.png'});


    // ==========================================
    // 2. FILE UPLOAD
    // ==========================================

    await page.goto('https://the-internet.herokuapp.com/upload');

    const fileInput = page.locator('#file-upload');

    await fileInput.setInputFiles('playwright/day20/day20-test-file.txt');

    await page.getByRole('button', { name: 'Upload' }).click();

    await expect(page.locator('#uploaded-files')).toContainText('day20-test-file.txt');

    await page.screenshot({path: 'screenshots/playwright/02-file-upload.png'});


    // ==========================================
    // 3. COOKIES
    // ==========================================

    await page.goto('https://the-internet.herokuapp.com/');

    await page.context().addCookies([
        {
            name: 'day20Cookie',
            value: 'Lasya',
            domain: 'the-internet.herokuapp.com',
            path: '/'
        }
    ]);

    const cookies = await page.context().cookies();

    const testCookie = cookies.find(cookie => cookie.name === 'day20Cookie');

    expect(testCookie?.value).toBe('Lasya');

    await page.screenshot({path: 'screenshots/playwright/03-cookie.png'});

});