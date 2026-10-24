class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30,
                             31, 31, 30, 31, 30, 31};

        int start = Math.max(dayOfYear(arriveAlice, daysInMonth),
                            dayOfYear(arriveBob, daysInMonth));
        int end = Math.min(dayOfYear(leaveAlice, daysInMonth),
                           dayOfYear(leaveBob, daysInMonth));

        return Math.max(0, end - start + 1);
    }

    private int dayOfYear(String date, int[] daysInMonth) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        int total = day;
        for (int i = 0; i < month - 1; i++) {
            total += daysInMonth[i];
        }
        return total;
    }
}