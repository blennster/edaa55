
%S = input('Ange S: ');
function aprxSqrt = asqrt(S)
    x = S / 2;

    sqrx = @(S, x) (x + S/x) / 2;

    format long
    x0 = 0;
    % Talet konvergerar d� skillnaden �r mindre �n 10^-6
    % Allts� forts�tt itererar fram tills det �r det (NOT operator)
    while ~abs(x - x0) < 10^-6 
        x0 = x;
        x = sqrx(S, x0);
    end
    aprxSqrt = x;
end