import { render, screen } from '@testing-library/react';
import App from './Component/index/Index';

test('renders learn react link', () => {
  render(<App />);

  expect(linkElement).toBeInTheDocument();
});
