# Refactoring record

## Named refactorings
1. Extract Enum — `MenuItem`.
2. Extract Class — `DiscountPolicy`.
3. Extract Interface — `PaymentStrategy`.
4. Replace Type Code with Enum — `PaymentMethod`.
5. Replace Conditional with Polymorphism — payment strategies.
6. Extract Factory — `PaymentStrategyFactory`.
7. Introduce Dependency Injection — `PaymentGateway`.
8. Extract Class — `OrderService`.
9. Separate business logic from console I/O.

## Static analysis
Run `mvn verify` on the workstation and record the actual Checkstyle/PMD result here. Do not invent counts.

| Refactoring applied | Smell removed | Commit hash |
|---|---|---|
| Extract MenuItem enum | Type code / magic prices | see `git log` |
| Extract DiscountPolicy | Long method / magic numbers | see `git log` |
| PaymentStrategy interface | Conditional complexity | see `git log` |
| PaymentStrategyFactory | Selection logic in order service | see `git log` |
| OrderService | Large class / mixed responsibilities | see `git log` |
