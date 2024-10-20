import sys
import cv2 as cv

def main():
    img = cv.imread(sys.argv[1], cv.IMREAD_GRAYSCALE)
    assert img is not None, "file could not be read, check with os.path.exists()"
    img2 = img.copy()
    template = cv.imread(sys.argv[2], cv.IMREAD_GRAYSCALE)
    assert template is not None, "file could not be read, check with os.path.exists()"

    methods = ['TM_CCOEFF', 'TM_CCOEFF_NORMED', 'TM_CCORR',
               'TM_CCORR_NORMED', 'TM_SQDIFF', 'TM_SQDIFF_NORMED']

    for meth in methods:
        img = img2.copy()
        method = getattr(cv, meth)

        res = cv.matchTemplate(img, template, method)
        min_val, max_val, min_loc, max_loc = cv.minMaxLoc(res)
        print((max_val + min_val) / 2)

if __name__ == "__main__":
    main()
