from setuptools import setup, find_packages

setup(
    name='apiverve_seodatascraper',
    version='1.2.2',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='SEO Data Scraper parses any public URL to collect title tags, meta descriptions, robots directives, and Open Graph or Twitter card previews. Paid plans add canonical URLs to verify indexing rules.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/seoscraper?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
