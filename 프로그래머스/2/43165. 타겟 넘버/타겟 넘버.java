class Solution {
    static int result=0;
	
	static void powerSet(int[] numbers, int target, int depth, boolean[] visit) {
		if(depth == numbers.length) {
			
			int sum=0;
			for(int i=0; i<numbers.length; i++) {
				
				int num = numbers[i];
				
				if(visit[i]) {
					sum += -num;
				}else {
					sum += num;
				}
			}
			if(sum == target) result++;
			
			return;
		}
		
		visit[depth] = true;
		powerSet(numbers, target, depth+1, visit);
		visit[depth] = false;
		powerSet(numbers, target, depth+1, visit);
		
	}
	
	public int solution(int[] numbers, int target) {
        int answer = 0;
        
        
        
        powerSet(numbers, target, 0, new boolean[numbers.length]);
        answer = result;
        
        return answer;
    }
}