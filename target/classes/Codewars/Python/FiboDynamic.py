def fibonacci_dynamic(n) -> int:
    if n==0 or n==1 : return n
    result = [0,1]
    for i in range(2,n+1):
        result.append(result[i-2] + result[i-1])
    return result[-1]

