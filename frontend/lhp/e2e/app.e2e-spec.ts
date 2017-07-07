import { LhpPage } from './app.po';

describe('lhp App', () => {
  let page: LhpPage;

  beforeEach(() => {
    page = new LhpPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
