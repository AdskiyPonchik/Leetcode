class Solution:
    def largestOddNumber(self, num:str) -> str:
        for i in range(len(num), 0, -1):
            if int(num[:i]) %2!=0:
                return num[:i]
        return ""

test = Solution()
print(test.largestOddNumber("4206"))