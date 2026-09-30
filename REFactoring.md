# Refactoring record

## Refactorings applied

1. **Extract Class** — token generation moved from Canteen to TokenGenerator.
2. **Encapsulate Field** — global tokenCounter was replaced by private state owned by TokenGenerator.
3. **Replace Type Code with Enum** — payment method strings are converted through PaymentMethod.
4. **Replace Magic Numbers with Named Constants** — bulk, loyalty, card, JazzCash and RAAST values are centralized in named constants.
5. **Extract Method** — order validation is isolated inside OrderService.validateOrder.
6. **Move Method / Data** — menu prices are owned by MenuItem instead of an item-name conditional chain.
7. **Remove Parameter** — the unused student-id parameter was removed from the order calculation API.
8. **Separate Query from Side Effect** — calculation is kept in calculateTotal, while charging is performed explicitly by charge.

## Characterization coverage

CanteenCharacterizationTest records the pre-refactoring observable results for cash, mixed items, bulk discount, card surcharge and JazzCash.

## Static analysis

Checkstyle is configured in pom.xml and runs during mvn verify. The build is configured to report violations without hiding them from the console.

| Refactoring applied | Smell removed | Commit |
|---|---|---|
| Extract TokenGenerator | Global token state / mixed responsibility | ca3113b |
| Remove student-id parameter | Unused parameter | ca3113b |
| Update characterization API | Tests coupled to legacy signature | b413314 |
| Payment constants and enums | Magic numbers / string type codes | existing refactor baseline |
| Order validation extraction | Long method / validation mixed with calculation | existing refactor baseline |

Exact Checkstyle counts should be taken from the mvn verify CI run rather than guessed.
