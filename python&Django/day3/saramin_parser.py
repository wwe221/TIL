from bs4 import BeautifulSoup
import requests
url = "http://www.saramin.co.kr/zf_user/jobs/list/job-category?exp_cd=1&edu_min=8&edu_max=11&cat_cd=404&panel_type=&search_optional_item=y&search_done=y&panel_count=y"
url2= "http://www.saramin.co.kr/zf_user/jobs/list/job-category?exp_cd=1&edu_min=8&edu_max=11&cat_cd=407&panel_type=&search_optional_item=y&search_done=y&panel_count=y"
url3= "http://www.saramin.co.kr/zf_user/jobs/list/job-category?cat_cd=404%2C407&exp_cd=1&edu_min=8&edu_max=11&panel_type=&search_optional_item=y&search_done=y&panel_count=y"
response = requests.get(url)
html = BeautifulSoup(response.text,'html.parser')

'''
company = html.select('.part_top')
for com in company:
    name = com.select_one('.company_name')
    rec = com.select_one('.recruit_name')
    cond  = com.select_one('.list_recruit_condition')
    print(f'{name.text} :: {rec.text} -{cond.text}')
    break
'''
company_list = html.select('ul.product_list li')
for com in company_list:
    company_info_url =f"http://www.saramin.co.kr{com.select_one('a')['href']}"
    idx = company_info_url.split('=')[-1]
    company_info_url = 'http://www.saramin.co.kr/zf_user/jobs/relay/view-ajax'
    company_info_param = { 'rec_idx':idx }
    company_response = requests.post(company_info_url, params = company_info_param)
    company_html = BeautifulSoup(company_response.text,'html.parser')
    company_title = company_html.select_one('.company_name').text
    print(company_title.strip())
    break
#사람인 나머지 데이터 파싱 !?
#다음 웹툰 일요일 첫번째 웹툰 상세페이지 크롤링