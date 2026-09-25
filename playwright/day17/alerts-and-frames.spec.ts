import { test, expect } from '@playwright/test';

test('Day 17 - Alerts and Frames', async ({ page }) => {

    // ==========================================
    // 1. JAVASCRIPT ALERT
    // ==========================================

    await page.goto('https://the-internet.herokuapp.com/javascript_alerts');

    page.once('dialog', async dialog => {

        expect(dialog.message()).toBe('I am a JS Alert');

        await dialog.accept();
    });

    await page.getByRole('button', { name: 'Click for JS Alert' }).click();


    // ==========================================
    // 2. JAVASCRIPT CONFIRM
    // ==========================================

    page.once('dialog', async dialog => {

        expect(dialog.message()).toBe('I am a JS Confirm');

        await dialog.dismiss();
    });

    await page.getByRole('button', { name: 'Click for JS Confirm' }).click();


    // ==========================================
    // 3. JAVASCRIPT PROMPT
    // ==========================================

    page.once('dialog', async dialog => {

        expect(dialog.message()).toBe('I am a JS prompt');

        await dialog.accept('Lasya');
    });

    await page.getByRole('button', { name: 'Click for JS Prompt' }).click();


    // ==========================================
    // 4. NESTED FRAMES
    // ==========================================

    await page.goto('https://the-internet.herokuapp.com/nested_frames');

    const topFrame = page.frameLocator('frame[name="frame-top"]');

    const leftFrame = topFrame.frameLocator('frame[name="frame-left"]');

    await expect(leftFrame.locator('body')).toHaveText('LEFT');
});