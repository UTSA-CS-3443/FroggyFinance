package edu.utsa.cs3443.informationtab;

public class ContentManager {
    private static final String LOANS = "Loans";
    private static final String CREDIT = "Credit/Debit";
    private static final String[] LOAN_TITLES = new String[]{
            "Chapter 1 (Toad)", "Chapter 2 (Caterpillar)", "Chapter 3 (Firefly)",
            "Chapter 4 (Dragon Fly)", "Chapter 5 (Grasshopper)"
    };
    private static final String[] LOAN_PARAGRAPHS = new String[]{
            "Paragraph for Loan Level 1.", "Paragraph for Loan Level 2.",
            "Paragraph for Loan Level 3.", "Paragraph for Loan Level 4.",
            "Paragraph for Loan Level 5."
    };
    private static final String[] CREDIT_TITLES = new String[]{
            "Chapter 1 (Toad)", "Chapter 2 (Caterpillar)",
            "Chapter 3 (Firefly)", "Chapter 4 (Dragon Fly)",
            "Chapter 5 (Grasshopper)"
    };
    private static final String[] CREDIT_PARAGRAPHS = new String[]{
            "Paragraph for Credit/Debit Level 1.", "Paragraph for Credit/Debit Level 2.",
            "Paragraph for Credit/Debit Level 3.", "Paragraph for Credit/Debit Level 4.",
            "Paragraph for Credit/Debit Level 5."
    };

    public String getTitle(String topic, int level) {
        if (topic.equalsIgnoreCase(LOANS)) {
            return LOAN_TITLES[level - 1];
        } else if (topic.equalsIgnoreCase(CREDIT)) {
            return CREDIT_TITLES[level - 1];
        } else {
            return "No title available.";
        }
    }

    public String getParagraph(String topic, int level) {
        if (topic.equalsIgnoreCase(LOANS)) {
            return LOAN_PARAGRAPHS[level - 1];
        } else if (topic.equalsIgnoreCase(CREDIT)) {
            return CREDIT_PARAGRAPHS[level - 1];
        } else {
            return "No paragraph available.";
        }
    }

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









