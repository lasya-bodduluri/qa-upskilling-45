import { Page, Locator } from '@playwright/test';

export class InventoryPage {
    readonly page: Page;
    readonly pageTitle: Locator;

    constructor(page: Page) {
        this.page = page;
        this.pageTitle = page.locator('.title');
    }

    async getPageTitleText(): Promise<string> {
        return await this.pageTitle.textContent() || '';
    }
}