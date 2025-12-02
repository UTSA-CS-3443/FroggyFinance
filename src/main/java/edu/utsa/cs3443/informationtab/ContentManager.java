package edu.utsa.cs3443.informationtab;

/**
 * The {@code ContentManager} class provides access to titles and paragraphs
 * related to two educational financial topics: Loans and Credit/Debit.
 * <p>
 * It stores predefined chapter titles and paragraph content for each topic
 * and provides methods to retrieve titles, paragraphs, and paragraph counts.
 */
public class ContentManager {

    /** Constant representing the Loans topic identifier. */
    private static final String LOANS = "Loans";

    /** Constant representing the Credit/Debit topic identifier. */
    private static final String CREDIT = "Credit/Debit";

    /** Titles for each chapter in the Loans topic. */
    private static final String[] LOAN_TITLES = new String[]{
            "Chapter 1 (Toad)",
            "Chapter 2 (Caterpillar)",
            "Chapter 3 (Firefly)",
            "Chapter 4 (Dragon Fly)",
            "Chapter 5 (Grasshopper)"
    };

    /** Paragraphs containing educational content for each Loans chapter. */
    private static final String[] LOAN_PARAGRAPHS = new String[]{
            "Auto loans are specialized installment loans offered by banks, credit unions, and dealerships to help consumers finance the purchase of new or used vehicles, allowing borrowers to pay over time rather than all at once. Student loans, issued either by the federal government or private lenders, are not available to just anyone; they are specifically intended for qualified students pursuing higher education and often require enrollment verification, financial need assessments, or credit checks. Mortgage loans are long-term, secured loans designed to assist individuals and families in purchasing homes, with the property itself serving as collateral throughout the repayment period. Personal loans are versatile, unsecured loans that can be used for a wide range of expenses—including medical bills, travel, emergencies, or consolidating debt—giving borrowers flexibility in how funds are applied. Credit cards operate as a revolving line of credit, effectively making them a form of loan that allows users to borrow money repeatedly up to a set limit, repay it, and borrow again as needed.",
            "The simple interest formula is written as Interest = Principal × Rate × Time, which means interest is calculated only on the original amount borrowed or invested, causing the interest earned or charged to remain the same every year rather than grow over time. When evaluating loans, the Annual Percentage Rate (APR) represents the total yearly cost of borrowing by combining the interest rate with additional fees, giving borrowers a clearer picture of what they will pay. Loans can have different types of interest structures, such as fixed-rate loans, where the interest rate stays the same throughout the entire loan term, and variable-rate loans, where the interest rate can change over time based on market conditions.",
            "Loans can be classified as secured or unsecured. Secured loans require collateral, such as a house or car, which the lender can claim if the borrower fails to repay, while unsecured loans do not require collateral but generally have higher interest rates to offset the lender’s risk. In some cases, a co-signer may be required for a loan; this person agrees to repay the loan if the primary borrower cannot. Borrowers can reduce the total interest paid over the life of a loan by paying more than the minimum monthly payment. Additionally, individuals are not limited to taking out only one loan at a time; they can have multiple loans simultaneously, as long as they meet the lender’s credit and income requirements.",
            "Fixed-rate mortgages provide borrowers with a stable interest rate and predictable monthly payments, protecting against rising interest rates, though they may have higher initial costs compared to adjustable-rate loans. In risk-based pricing, borrowers with higher interest rates do not always have poor credit; lenders may adjust rates based on various factors, such as loan type or market conditions. Secured lenders have priority over unsecured creditors in the event of bankruptcy, as their loans are backed by collateral. Adjustable-rate loans, even with interest rate caps, can still result in increased monthly payments if the underlying rate rises. Additionally, loan syndication allows multiple lenders to jointly fund a loan, spreading the credit risk among them rather than leaving a single lender fully exposed.",
            "Paying off a fixed-rate mortgage early does not always save the full interest amount because some loans may include prepayment penalties or have interest calculated differently. The APR (Annual Percentage Rate) on a loan often differs from the nominal interest rate because it includes additional fees and costs, providing a more complete picture of the loan’s true cost. Even a 0% interest loan can end up costing more than a standard interest loan due to hidden fees, higher prices, or other charges. In a fully amortizing loan, the interest portion of each payment decreases over time while the principal portion increases, allowing the loan to be completely paid off by the end of the term. Negative amortization occurs when monthly payments are less than the interest due, causing the loan balance to grow rather than shrink."
    };

    /** Titles for each chapter in the Credit/Debit topic. */
    private static final String[] CREDIT_TITLES = new String[]{
            "Chapter 1 (Toad)",
            "Chapter 2 (Caterpillar)",
            "Chapter 3 (Firefly)",
            "Chapter 4 (Dragon Fly)",
            "Chapter 5 (Grasshopper)"
    };

    /** Paragraphs containing educational content for each Credit/Debit chapter. */
    private static final String[] CREDIT_PARAGRAPHS = new String[]{
            "Credit cards are a form of borrowing that allow you to use a bank’s money up to a certain limit, with the requirement that you pay back what you spend, often with interest if the balance is not paid on time. Because of this, missing or delaying payments can lead to consequences such as late fees, higher interest charges, and potential damage to your credit score. Debit cards work differently; they allow you to make purchases using your own money that is already stored in a linked bank account, such as a checking or savings account. Prepaid cards, however, are not connected to a bank account or a credit line. Instead, they have a set amount of money loaded onto them in advance, and purchases are limited to the amount currently available on the card.",
            "Prepaid cards are payment cards that do not connect to any bank account; instead, money must be manually loaded onto them, and purchases can only be made up to the amount stored, with no interest charges since you are spending your own preloaded funds. Credit cards work differently because they allow you to borrow money from a bank up to a set credit limit, meaning the funds are not unlimited and must be repaid. If the full balance is not paid by the due date, the bank charges interest based on the card’s interest rate. Savings accounts, offered by banks and credit unions, are designed for storing money and earning interest over time, and they typically limit the number of withdrawals a customer can make each month.",
            "Prepaid cards allow you to spend only the money that has been loaded onto the card, so purchases exceeding the available balance will be declined. However, many prepaid cards can be reloaded with additional funds, allowing continued use. Credit cards have a set credit limit, and purchases cannot exceed this limit, even if you plan to pay the balance early. Savings accounts often limit the number of withdrawals allowed per month, but failing to use all available withdrawals does not result in fees; instead, exceeding the limit may incur penalties. Debit cards with overdraft protection can authorize purchases that exceed the account balance, with the bank covering the difference temporarily and often charging a fee for this service.",
            "Checking accounts often require a minimum balance, and failing to maintain it may result in monthly maintenance fees charged by the bank. Credit cards impact your credit score, but paying only the minimum payment each month is generally not enough to quickly improve your score; consistently paying more and maintaining low balances is more effective. Debit cards do not usually help build a credit score because they do not involve borrowing or repayment history. Prepaid cards, while convenient, often come with monthly maintenance fees or reload fees depending on the card provider. Additionally, closing a credit card account can reduce your total available credit, which may negatively affect your credit score by increasing your credit utilization ratio.",
            "Prepaid cards are ideal for individuals who want to strictly control spending, avoid overdraft fees, or make purchases without a traditional bank account, because you can only spend the amount loaded onto the card. Debit cards, in contrast, are linked to checking or savings accounts and may allow overdrafts, which can result in fees if the account balance is insufficient. Credit cards are beneficial for building a credit history, demonstrating reliability to lenders, and strengthening eligibility for loans, mortgages, or rental applications. They also provide the ability to borrow beyond your available cash, making them useful in emergencies. Checking accounts are designed for everyday transactions, whereas savings accounts typically earn interest, making them better for storing money over time rather than for frequent spending."
    };

    /**
     * Returns the chapter title for the specified topic and level.
     *
     * @param topic the topic name (e.g., "Loans" or "Credit/Debit")
     * @param level the chapter number (1–5)
     * @return the corresponding chapter title, or a fallback message if the topic is invalid
     */
    public String getTitle(String topic, int level) {
        if (topic.equalsIgnoreCase(LOANS)) {
            return LOAN_TITLES[level - 1];
        } else if (topic.equalsIgnoreCase(CREDIT)) {
            return CREDIT_TITLES[level - 1];
        } else {
            return "No title available.";
        }
    }

    /**
     * Returns the paragraph text for the specified topic and level.
     *
     * @param topic the topic name (e.g., "Loans" or "Credit/Debit")
     * @param level the chapter number (1–5)
     * @return the corresponding paragraph, or a fallback message if the topic is invalid
     */
    public String getParagraph(String topic, int level) {
        if (topic.equalsIgnoreCase(LOANS)) {
            return LOAN_PARAGRAPHS[level - 1];
        } else if (topic.equalsIgnoreCase(CREDIT)) {
            return CREDIT_PARAGRAPHS[level - 1];
        } else {
            return "No paragraph available.";
        }
    }

    /**
     * Returns the number of paragraphs available for a given topic.
     *
     * @param topic the topic name (e.g., "Loans" or "Credit/Debit")
     * @return the number of paragraphs for that topic, or 0 if the topic is invalid
     */
    public int getParagraphCount(String topic) {
        if (topic.equalsIgnoreCase(LOANS)) {
            return LOAN_PARAGRAPHS.length;
        } else if (topic.equalsIgnoreCase(CREDIT)) {
            return CREDIT_PARAGRAPHS.length;
        } else {
            return 0;
        }
    }
}










