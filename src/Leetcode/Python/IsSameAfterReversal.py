class Solution:
    def isSameAfterReversals(self, num:int) -> bool:
        newnum = num
        reversed_num = 0
        while num:
            reversed_num = reversed_num * 10 + num % 10
            num //= 10
        reversed_again = 0
        while reversed_num:
            reversed_again = reversed_again * 10 + reversed_num % 10
            reversed_num //= 10
        return newnum == reversed_again

test = Solution()
print(test.isSameAfterReversals(526))