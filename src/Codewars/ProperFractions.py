def proper_fractions(n: int):
    """
    Difficulty: 4 kyu
    Euler function - easy
    """
    if n == 1: return 0
    res = n
    x = n
    p = 2
    while p*p <=x:
        if x%p == 0:
            while x%p==0:
                x //=p
            res -= res//p
        p+=1 if p==2 else 2
    if x>1:
        res-=res//x
    return res

print(proper_fractions(25))