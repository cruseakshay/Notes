# Automated Trading With R

- Performance metrics
  - Total return
  - Sharpe Ratio
  - Total Return to Max Drawdown Ratio

- ways to measure risk-adjusted return
  - equity curve : trading account value plotted Vs time OR cash on hand plus the equity value of portfolio assets Vs time.
    - linear rise if we trade with a uniform account size or exponential if we reinvest gains.
  - return series : list of returns on the account at each trading period.
    The return series is the portfolio gain or loss as a percentage of tradable capital at each trading period.

- Risk-Return Metrics

![Risk-Return Metrics](./slides/risk_return_metrics.png)

- Sharpe Ratio
  - best-known metrics for measuring strategy performance
  - long-recognized fund and strategy performance metric
  - It was developed in 1966 by William F. Sharpe

- theoretical shortfalls of the Sharpe Ratio
  - The denominator penalizes large gains as well as large losses.
  - Inference methods using the Sharpe Ratio require returns to be normally distributed. Financial assets are known to exhibit highly non-normal returns.
  - The denominator standardizes against the mean return, but the numerator standardizes against a separate benchmark rate or zero. Performance ratios are known to benefit in robustness from the consistent application of benchmarking figures in both the numerator and the denominator.