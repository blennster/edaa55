
%S = input('Ange S: ');
function [aprxSqrt, i] = asqrt(S)
    x = S / 2;

    sqrx = @(S, x) (x + S/x) / 2;

    format long
    x0 = 0;
    i = 0;
    % Talet konvergerar då skillnaden är mindre än 10^-6
    % Alltså fortsätt itererar fram tills det är det (NOT operator)
    while ~abs(x - x0) < 10^-6 
        x0 = x;
        x = sqrx(S, x0);
        i = i + 1;
    end
    aprxSqrt = x;
end